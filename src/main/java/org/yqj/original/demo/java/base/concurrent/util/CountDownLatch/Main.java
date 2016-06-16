package org.yqj.original.demo.java.base.concurrent.util.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class Main {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Decrementer decrementer = new Decrementer(countDownLatch);
        Waiter waiter = new Waiter(countDownLatch);

        new Thread(waiter).start();
        new Thread(decrementer).start();
        Thread.sleep(5000);
        System.out.println("system over");
    }
}
