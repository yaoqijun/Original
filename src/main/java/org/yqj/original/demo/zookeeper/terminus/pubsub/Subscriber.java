/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.pubsub;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.yqj.original.demo.zookeeper.terminus.ZKClientFactory;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-01
 */
public class Subscriber {
    private final CuratorFramework client;

    //private final PathChildrenCache pcc;

    private final Paths paths;

    public Subscriber(final ZKClientFactory zkClientFactory, String topic) throws Exception {
        this(zkClientFactory, "/pubsub", topic);
    }

    public Subscriber(final ZKClientFactory zkClientFactory, final String basePath, final String topic) throws Exception {
        this.client = zkClientFactory.getClient();
        this.paths = new Paths(basePath, topic);

        if (client.checkExists().forPath(paths.getClientBase()) == null) {
            client.create().creatingParentsIfNeeded().forPath(paths.getClientBase());
        }

        if (client.checkExists().forPath(paths.getTopicBase()) == null) {
            client.create().creatingParentsIfNeeded().forPath(paths.getTopicBase());
        }

        if(client.checkExists().forPath(paths.getSubscriberBase()) == null){
            client.create().creatingParentsIfNeeded().forPath(paths.getSubscriberBase());
        }

        //记录当前存活的订阅者
        if(client.checkExists().forPath( paths.getClientPathOfLocalhost())==null) {
            this.client.create().withMode(CreateMode.EPHEMERAL).forPath(
                    paths.getClientPathOfLocalhost());
        }

        if(client.checkExists().forPath(paths.getSubscriberPathOfLocalhost())== null) {
            //记录topic订阅关系
            this.client.create().withMode(CreateMode.EPHEMERAL).forPath(
                    paths.getSubscriberPathOfLocalhost());
        }


        //创建一个监听的目标
        if(this.client.checkExists().forPath(paths.getTopicPathOfLocalHost())==null){
            this.client.create().forPath(paths.getTopicPathOfLocalHost());
        }
    }

    public void subscribe(final SubscribeCallback callback) throws Exception {
        final CuratorWatcher callbackWatcher = new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception {
                byte[] data = client.getData().usingWatcher(this).forPath(paths.getTopicPathOfLocalHost());
                callback.fire(data);
            }
        };

        client.getData().usingWatcher(callbackWatcher).forPath(paths.getTopicPathOfLocalHost());
    }
}
