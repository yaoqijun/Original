/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.pubsub;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.utils.ZKPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yqj.original.demo.zookeeper.terminus.ZKClientFactory;

import java.util.List;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-02
 */
public class Cleaner {

    private final static Logger log = LoggerFactory.getLogger(Cleaner.class);

    private final PathChildrenCache liveHostsPcc;

    private final PathChildrenCache topicPcc;

    private final Paths paths;

    private final CuratorFramework client;

    public Cleaner(final ZKClientFactory zkClientFactory, final String topic) throws Exception {
        this(zkClientFactory, "/pubsub", topic);
    }

    public Cleaner(final ZKClientFactory zkClientFactory, final String basePath, final String topic) throws Exception {
        this.client = zkClientFactory.getClient();
        this.paths = new Paths(basePath, topic);
        this.liveHostsPcc = new PathChildrenCache(client, paths.getClientBase(), false);
        liveHostsPcc.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);

        this.topicPcc = new PathChildrenCache(client, paths.getTopicBase(), false);
        topicPcc.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
    }

    // clean orphan topic message
    public void clean() throws Exception{
        List<ChildData> liveHostsChildData = liveHostsPcc.getCurrentData();
        if (liveHostsChildData.isEmpty()) {
            log.info("no client exists for path: {}", paths.getClientBase());
            return;
        }

        List<String> liveHosts = Lists.transform(liveHostsChildData, new Function<ChildData, String>() {
            @Override
            public String apply(ChildData child) {
                return ZKPaths.getNodeFromPath(child.getPath());
            }
        });

        List<ChildData> topicChildData = topicPcc.getCurrentData();
        if (topicChildData.isEmpty()) {
            log.info("no topic exists for path: {}", paths.getTopicBase());
            return;
        }

        for (ChildData child : topicChildData) {
            String hostName = ZKPaths.getNodeFromPath(child.getPath());
            if(!liveHosts.contains(hostName)){
                this.client.delete().forPath(paths.getTopicPathOfHost(hostName));
            }
        }

    }

}
