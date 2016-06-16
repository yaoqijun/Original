package org.yqj.original.demo.java.base.concurrent.util.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class Consumer implements Runnable {

    private BlockingQueue queue = null;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            System.out.println("consumer get :" + queue.take());
            System.out.println("consumer get :" +queue.take());
            System.out.println("consumer get :" +queue.take());
        }catch (Exception e){
            System.out.println("consumer exception result"+e);
        }
    }
}
