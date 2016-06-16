package org.yqj.original.demo.java.base.concurrent.util.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe: 测试对应的线程执行的方式
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {

        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveCount = 5000;

        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize,maxPoolSize,
                keepAliveCount, TimeUnit.SECONDS,
                new LinkedBlockingDeque());
    }
}
