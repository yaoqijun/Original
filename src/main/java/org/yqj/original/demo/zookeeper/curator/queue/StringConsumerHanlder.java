package org.yqj.original.demo.zookeeper.curator.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.state.ConnectionState;

/**
 * Created by yaoqijun.
 * Date:2015-12-25
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class StringConsumerHanlder implements QueueConsumer<String> {

    @Override
    public void consumeMessage(String s) throws Exception {
        System.out.println("消息被消费了，消息内容=" + s);
    }

    @Override
    public void stateChanged(CuratorFramework client, ConnectionState newState) {
        System.out.println("当前状态=" + newState.name());
        System.out.println("当前data=" + client.getData());
    }
}
