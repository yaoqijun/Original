package org.yqj.original.demo.java.base.concurrent.util.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class Producer implements Runnable {

    private BlockingQueue queue = null;

    public Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            queue.put("1");
            System.out.println("produce put 1 in it");
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("producer put 2 in it");
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("produce put 3 in it");

        }catch (Exception e){
            System.out.println("produce exception, "+e);
        }
    }
}
