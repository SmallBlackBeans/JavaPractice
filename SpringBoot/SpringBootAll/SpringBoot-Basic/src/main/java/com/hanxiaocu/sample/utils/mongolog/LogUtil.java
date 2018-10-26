package com.hanxiaocu.sample.utils.mongolog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//import com.meihaofenqi.domain.admin.WorkerOperLogDO;
//import com.meihaofenqi.utils.ConstantUtils;
//import com.meihaofenqi.utils.MailUtils;

/**
 * Created by sunliangguo on 2017/6/28.
 */
public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public final static String BEAN_URL      = "url"; // URL路径
    public final static String BEAN_OPERATOR = "operator_id"; // 操作员

    /**
     * 异步发送日志线程池
     */
    private final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 3,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.DiscardOldestPolicy());

}
