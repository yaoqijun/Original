package org.yqj.original.demo.java.base.concurrent.util.CountDownLatch;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe: latchDownCount 减少对应的数据内容
 */
@AllArgsConstructor
@NoArgsConstructor
public class Decrementer implements Runnable {

    private CountDownLatch countDownLatch = null;

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("i will count down first");
            countDownLatch.countDown();

            Thread.sleep(1000);
            System.out.println("i will count down second");
            countDownLatch.countDown();

            Thread.sleep(1000);
            System.out.println("i will count down third");
            countDownLatch.countDown();
        }catch (Exception e){
            System.out.println("error decrement error, cause:" +e);
        }
    }
}
