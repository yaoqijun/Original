package org.yqj.original.demo.java.base.concurrent.util.exchange;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.Exchanger;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@AllArgsConstructor
@NoArgsConstructor
public class ExchangerRunnable implements Runnable {

    private Object currentObject;

    private Exchanger exchanger;

    @Override
    public void run() {
        try {
            System.out.println("current contain object is "+ currentObject);
            Object getObject =  exchanger.exchange(currentObject);
            System.out.println("get from exchange object is "+getObject);
        }catch (Exception e){
            System.out.print("exception exchange "+e);
        }
    }
}
