package org.yqj.original.demo.java.base.concurrent.util.CountDownLatch;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@AllArgsConstructor
@NoArgsConstructor
public class Waiter implements Runnable {

    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        try{
            System.out.println("i will wait");
            countDownLatch.await();
            System.out.println("i get it ");
        }catch (Exception e){
            System.out.println("waite error ,cause:" + e);
        }
    }
}
