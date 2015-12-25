/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.pubsub;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-01
 */
public interface SubscribeCallback {

    /**
     * 节点的数据发生变化了
     * @param data  最新的data
     */
    void fire(byte[] data);
}
