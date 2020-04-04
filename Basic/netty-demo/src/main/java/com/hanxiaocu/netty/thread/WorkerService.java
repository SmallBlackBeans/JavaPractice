package com.hanxiaocu.netty.thread;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/16 9:29 AM
 */

public class WorkerService {

	//真正执行任务的包装线程，用它来控制任务的结束，因为包装线程结束，内部的守护进程也会结束
	private Thread executeService;

	//监听线程，不阻塞 主线程的执行
	private Thread listenerService;

	private volatile boolean finished = false;

	//task  外部传入的任务，创建为守护线程，
	public void execute(Runnable task, ResultCallback callback) {
		executeService = new Thread(() -> {
			Thread runner = new Thread(task, "后台线程");
			runner.setDaemon(true);
			runner.start();
			try {
				System.out.println("后台线程开始执行...");
				runner.join();//阻塞直到完成
				finished = true;
				System.out.println("后台线程开始执行...");
				callback.complete();
			} catch (InterruptedException e) {
				System.out.println("打断正在工作的线程......");
				e.printStackTrace();
			}
		}, "执行线程");

		executeService.start();
	}

	//监听在一定的时间内完成
	public void listener(long mills) {
		System.out.println("开启监听......");
		listenerService = new Thread(() -> {
			long beginTime = System.currentTimeMillis();
			while (!finished) {
				if (System.currentTimeMillis() - beginTime > mills) {
					System.out.println("工作耗时过长,开始打断...");
					executeService.interrupt();
					listenerService.interrupt();
					break;
				}
				try {
					executeService.sleep(100L);//每隔100毫秒检测一次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		listenerService.start();
	}

	private interface ResultCallback {
		void complete();

		default void lamda() {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WorkerService service = new WorkerService();
		long start = System.currentTimeMillis();
		final boolean[] finished = {false};
		service.execute(() -> {
					try {
						// TODO 模拟加载数据
						Thread.sleep(3 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}, new ResultCallback() {
					@Override
					public void complete() {
						System.out.println("报告老大，我完成了也");
						finished[0] = true;
					}
				}
		);
		service.listener(4 * 1000);

		while (!finished[0]) {
			Thread.sleep(1000L);
			System.out.println("主线程还能继续玩耍，谁都不能打断我");
		}
	}
}
