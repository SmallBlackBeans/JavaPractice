package com.hanxiaocu.MultiThread.threadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/16 12:58 PM
 */
public class TaskThreadPoolExecutor extends Thread {

	private static ThreadGroup group = new ThreadGroup("TaskThreadGroup");

	private final static LinkedList<Runnable> task_queue = new LinkedList<>();//任务队列
	private final static List<TaskThread> worker_threads = new ArrayList<>();//线程容器，从任务队列中取任务

	private int minSize;//线程池最小数量
	private int maxSize;//线程池最大数量
	private int activeSize;//活跃的线程数量，默认5

	private int poolSize;//线程池大小，在minSize - maxSize 之间进变化
	private int maxQueuesize;//队列接收的最大任务数量

	private DiscardPolicy discardPolicy;

	//线程池是否被销毁
	private volatile boolean destory = false;

	TaskThreadPoolExecutor() {
		this(2, 10, 5, 100, () -> {
			throw new DiscardException("[拒绝执行] - [任务队列溢出...]");
		});
	}

	TaskThreadPoolExecutor(int minSize, int maxSize, int activeSize, int maxQueuesize, DiscardPolicy discardPolicy) {
		this.minSize = minSize;
		this.maxSize = maxSize;
		this.activeSize = activeSize;
		this.maxQueuesize = maxQueuesize;
		this.discardPolicy = discardPolicy;
		initPool();
	}

	public void submit(Runnable task) {
		if (destory) {
			throw new IllegalStateException("线程池已销毁...");
		}
		synchronized (task_queue) {
			if (task_queue.size() > maxQueuesize) {
				discardPolicy.discard();
			}
			//将任务加入任务队列
			task_queue.add(task);
			//唤醒等待的线程去执行任务
			task_queue.notifyAll();
		}
	}

	void shutdown() throws InterruptedException {
		int activeCount = group.activeCount();
		//还有任务没有完成
		while (!task_queue.isEmpty() && activeCount > 0) {
			Thread.sleep(100);
		}

		int intVal = worker_threads.size();
		while (intVal > 0) {
			for (TaskThread thread : worker_threads) {
				//没有任务的时候，这个线程是挂起的,关闭这些闲置的线程
				if (thread.taskState == TaskState.SUPPEND) {
					thread.close();
					intVal--;
				} else {
					Thread.sleep(50);
				}
			}
		}

		this.destory = true;
		task_queue.clear();
		worker_threads.clear();
		this.interrupt();
		System.out.println("线程池关闭");
	}

	/**
	 * 添加任务
	 */
	public void createWorkerTask() {
		TaskThread thread = new TaskThread();
		thread.taskState = TaskState.FREE;
		worker_threads.add(thread);
		thread.start();
	}

	private void initPool() {
		for (int i = 0; i < this.minSize; i++) {
			this.createWorkerTask();
		}
		//初始是最新线程池大小
		this.poolSize = minSize;
		this.start();
	}

	@Override
	public void run() {
		while (!this.destory) {
			try {
				Thread.sleep(5_000L);
				if (task_queue.size() > minSize && poolSize < activeSize) {
					for (int i = minSize; i < activeSize; i++) {
						this.createWorkerTask();
					}
					this.poolSize = activeSize;
					System.out.println("[扩容到活跃线程数] -[" + toString() + "]");
				} else if (task_queue.size() > maxSize && poolSize < maxSize) {
					for (int i = poolSize; i < maxSize; i++) {
						this.createWorkerTask();
					}
					System.out.println("[扩容到最大线程数] -[" + toString() + "]");
					this.poolSize = maxSize;
				} else {
					//对线程容器加锁，进行资源回收，线程释放,保持固定的活跃线程数量就行
					synchronized (worker_threads) {
						int releaseSize = poolSize - activeSize;
						Iterator<TaskThread> iterator = worker_threads.iterator();
						while (iterator.hasNext()) {
							if (releaseSize <= 0) {
								break;
							}
							TaskThread taskThread = iterator.next();
							//只回收闲置的线程
							if (taskThread.taskState == TaskState.FREE) {
								taskThread.close();
								iterator.remove();
								releaseSize--;
							}
						}
						System.out.println("[资源回收] - [" + toString() + "]");
					}
					poolSize = activeSize;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("资源释放");
			}
		}
	}

	@Override
	public String toString() {
		return "TaskThreadPoolExecutor {" +
				"minSize=" + minSize +
				", maxSize=" + maxSize +
				", activeSize=" + activeSize +
				", poolSize=" + poolSize +
				", 未运行任务数量=" + task_queue.size() +
				'}';
	}

	/**
	 * 任务线程
	 */
	public static class TaskThread extends Thread {

		//线程状态
		private TaskState taskState;
		//线程编号
		private static int threadInitNumber;

		private static synchronized String nextThreadName() {
			return "TaskThread-" + ++threadInitNumber;
		}

		TaskThread() {
			super(group, nextThreadName());
		}

		@Override
		public void run() {
			Runnable target;
			//当线程空闲时，回转到这里
			OUTER:
			while (this.taskState != TaskState.TERMINATED) {
				synchronized (task_queue) {
					//当前线程是空闲的，但是任务队列中没有任务,那么这个线程就挂起，等待有任务的时候被唤醒
					while (this.taskState == TaskState.FREE && task_queue.isEmpty()) {
						try {
							this.taskState = TaskState.SUPPEND;
							task_queue.wait();
						} catch (InterruptedException e) {
							break OUTER;
						}
					}
					//获取任务执行
					target = task_queue.removeFirst();//FIFO
				}
				if (target != null) {
					this.taskState = TaskState.RUNNABLE;
					target.run();
					this.taskState = TaskState.FREE;
				}
			}
		}

		void close() {
			this.taskState = TaskState.TERMINATED;
			this.interrupt();
		}
	}

	/**
	 * 线程状态
	 */
	private enum TaskState {
		FREE, //空闲的
		RUNNABLE,//使用中
		SUPPEND,//挂起
		TERMINATED;//销毁的
	}

	/**
	 * 放弃任务的策略： 当任务队列也满的时候
	 */
	interface DiscardPolicy {
		void discard() throws DiscardException;
	}

	static class DiscardException extends RuntimeException {

		private static final long serialVersionUID = -7109205618453354364L;

		public DiscardException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
		TaskThreadPoolExecutor executor = new TaskThreadPoolExecutor();
		IntStream.range(0, 100).forEach(i ->
				executor.submit(() -> {
					System.out.printf("[线程] - [%s] 开始工作...\n", Thread.currentThread().getName());
					try {
						Thread.sleep(2_000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("[线程] - [%s] 工作完毕...\n", Thread.currentThread().getName());
				})
		);
	}
}
