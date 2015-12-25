package org.yqj.original.demo.zookeeper.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class AbstractZooKeeper implements Watcher {

    private static final int SESSION_TIME   = 2000;

    protected ZooKeeper zooKeeper;

    protected CountDownLatch countDownLatch=new CountDownLatch(1);

    public void connect(String hosts) throws Exception{
        zooKeeper = new ZooKeeper(hosts,SESSION_TIME,this);
        countDownLatch.await();
    }

    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }

    public void close() throws InterruptedException{
        zooKeeper.close();
    }
}
