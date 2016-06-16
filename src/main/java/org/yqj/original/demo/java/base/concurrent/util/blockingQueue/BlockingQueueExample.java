package org.yqj.original.demo.java.base.concurrent.util.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class BlockingQueueExample {
    public static void main(String[] args) throws Exception{
        System.out.println("this is block content");

        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Consumer consumer = new Consumer(queue);

        Producer producer = new Producer(queue);

        new Thread(consumer).start();
        new Thread(producer).start();
        Thread.sleep(10000);
        System.out.println("finish blocking queue result");

    }
}
