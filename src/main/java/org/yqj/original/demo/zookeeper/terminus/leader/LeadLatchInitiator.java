/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.yqj.original.demo.zookeeper.terminus.ZKClientFactory;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-06-05
 */
public class LeadLatchInitiator {

    private final CuratorFramework client;

    private final String path;

    private LeaderLatch leaderLatch;

    /**
     * @param zkClientFactory   zkClient factory
     * @throws Exception   如果连接zookeeper失败则抛出此异常
     */
    public LeadLatchInitiator(final ZKClientFactory zkClientFactory, String path) throws Exception{
        this.client = zkClientFactory.getClient();
        this.path = path;
    }

    /**
     * 初始化
     * @param identity  当前candidate的标识
     * @param listeners    如果被选举为leader, 则需要执行的操作
     * @throws Exception  如果操作失败
     */
    public void init( String identity, LeaderLatchListener... listeners) throws Exception{

        leaderLatch = new LeaderLatch(client, path, identity);

        for (LeaderLatchListener listener : listeners) {
            leaderLatch.addListener(listener);
        }

        leaderLatch.start();

        //return leaderLatch;
    }

    /**
     * 判断当前candidates是否已经被选为leader
     //* @param leaderLatch 当前candidate
     * @return  是否已经被选为leader
     * @throws Exception  如果操作失败, 抛出异常
     */
    public boolean isLeader() throws Exception{
        return leaderLatch.hasLeadership();
    }


    /**
     * 获取当前leader的id
     * @return  当前leader的id
     * @throws Exception 如果操作失败, 抛出异常
     */
    public String currentLeaderId() throws Exception{
        return leaderLatch.getLeader().getId();
    }

    /**
     * 关闭到zookeeper的连接
     */
    public void close() throws Exception{
        leaderLatch.close();
    }
}
