package org.yqj.original.demo.zookeeper.curator.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.DistributedQueue;
import org.apache.curator.framework.recipes.queue.QueueBuilder;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by yaoqijun.
 * Date:2015-12-25
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class StringQueueClient {

    private static final String PATH = "/queuetest";

    private static final String LOCK_PATH = "/queuelock";

    private DistributedQueue<String> queue;

    public StringQueueClient(int length) {
        try {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.28.138", retryPolicy);
            client.start();
            QueueBuilder<String> builder = QueueBuilder.builder(client, null, new StringQueueSerializer(), PATH);
            builder.maxItems(length);
            queue = builder.lockPath(LOCK_PATH).buildQueue();// 消费担保
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringQueueClient(QueueConsumer<String> handler) {
        try {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.28.138", retryPolicy);
            client.start();
            QueueBuilder<String> builder = QueueBuilder.builder(client, handler, new StringQueueSerializer(), PATH);
            queue = builder.lockPath(LOCK_PATH).buildQueue();// 消费担保
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String message) throws Exception {
        queue.put(message);
    }

    public void start() throws Exception {
        queue.start();
    }

    public void close() throws Exception {
        queue.close();
    }
}
