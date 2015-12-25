package org.yqj.original.demo.zookeeper.curator.atomic;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-12-25
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class DistributedAtomicIntegerExample {

    private static final String PATH = "/counter";

    public static void main(String[] args) {
        System.out.println("Transaction test");
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.28.138", retryPolicy);

        client.start();

        DistributedAtomicInteger counter =new DistributedAtomicInteger(client, PATH, new RetryNTimes(3, 1000));

        try {
            List<Thread> jobs = Lists.newArrayList();
            // 开1k个线程，不用同步机制，同时启动
            for (int i = 0; i < 1000; i++) {
                jobs.add(new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            counter.increment();
                        } catch (Exception e) {
                        }
                    }
                }));

            }

            for (Thread t : jobs) {
                t.start();
            }

            // 保证线程全部执行完毕
            Thread.sleep(10000);

            System.out.println("计数器最终的值=" + counter.get().postValue());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }

}
