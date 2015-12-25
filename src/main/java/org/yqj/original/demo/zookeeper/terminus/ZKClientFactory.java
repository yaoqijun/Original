package org.yqj.original.demo.zookeeper.terminus;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ZKClientFactory {
    private final CuratorFramework client;

    /**
     * @param zookeeperConnectionString   zookeeper的连接信息
     * @throws Exception   如果连接zookeeper失败则抛出此异常
     */
    public ZKClientFactory(String zookeeperConnectionString) throws Exception{
        this.client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, new ExponentialBackoffRetry(1000, 3));
        client.start();
        client.getZookeeperClient().blockUntilConnectedOrTimedOut();
    }

    public CuratorFramework getClient(){
        return client;
    }

    public void destroy(){
        client.close();
    }
}
