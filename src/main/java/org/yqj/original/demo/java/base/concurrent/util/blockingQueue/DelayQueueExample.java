package org.yqj.original.demo.java.base.concurrent.util.blockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class DelayQueueExample {
    public static void main(String[] args) {
        System.out.println("out print content");
        DelayQueue queue = new DelayQueue();
        Delayed delayed = new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        };
        // todo input element order by release time content

    }
}
