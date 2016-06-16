package org.yqj.original.demo.java.base.concurrent.util.exchange;

import java.util.concurrent.Exchanger;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
        Exchanger exchanger = new Exchanger();

        new Thread(new ExchangerRunnable("A",exchanger)).start();
        new Thread(new ExchangerRunnable("B",exchanger)).start();
        System.out.println("finish condition result");

        Thread.sleep(5000);
    }
}
