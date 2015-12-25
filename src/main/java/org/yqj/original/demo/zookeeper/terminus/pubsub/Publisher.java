/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.pubsub;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionFinal;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.utils.ZKPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yqj.original.demo.zookeeper.terminus.ZKClientFactory;

import java.util.List;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-01
 */
public class Publisher {
    private final static Logger log = LoggerFactory.getLogger(Publisher.class);

    private final PathChildrenCache pcc;

    private final Paths paths;

    private final CuratorFramework client;

    public Publisher(final ZKClientFactory zkClientFactory, final String topic) throws Exception {
        this(zkClientFactory, "/pubsub", topic);
    }

    public Publisher(final ZKClientFactory zkClientFactory, final String basePath, final String topic) throws Exception {
        this.client = zkClientFactory.getClient();
        this.paths = new Paths(basePath, topic);
        this.pcc = new PathChildrenCache(client, paths.getSubscriberBase(), false);
        pcc.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
    }

    public void publish(byte[] data) throws Exception {

        List<ChildData> children = pcc.getCurrentData();
        if (children.isEmpty()) {
            log.warn("no subscribes for topic:{}", paths.getSubscriberBase());
            throw new IllegalStateException("no subscribers exists");
        }
        CuratorTransaction t = this.client.inTransaction();
        for (ChildData cd : children) {
            String hostName = ZKPaths.getNodeFromPath(cd.getPath());
            String targetPath = paths.getTopicPathOfHost(hostName);
            t = t.setData().forPath(targetPath, data).and();
        }
        if (t instanceof CuratorTransactionFinal) {
            ((CuratorTransactionFinal) t).commit();
        }
    }

    public void destroy() throws Exception {
        pcc.close();
    }
}
