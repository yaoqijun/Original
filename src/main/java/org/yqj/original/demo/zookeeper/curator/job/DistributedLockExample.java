package org.yqj.original.demo.zookeeper.curator.job;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class DistributedLockExample {

    private static final String PATH = "/locks";

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.28.138",  new ExponentialBackoffRetry(1000, 3));
        client.start();

        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, PATH);
        InterProcessLock readLock = lock.readLock();
        InterProcessLock writeLock = lock.writeLock();

        try {
//            client.delete().forPath(PATH);

            List<Thread> jobs = Lists.newArrayList();
            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(new ParallelJob("Parallel任务" + i, readLock));
                jobs.add(t);
            }

            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(new MutexJob("Mutex任务" + i, writeLock));
                jobs.add(t);
            }

            for (Thread t : jobs) {
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
    }
}
