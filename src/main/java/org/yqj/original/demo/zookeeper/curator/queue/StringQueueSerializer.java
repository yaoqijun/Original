package org.yqj.original.demo.zookeeper.curator.queue;

import org.apache.curator.framework.recipes.queue.QueueSerializer;

import java.nio.charset.Charset;

/**
 * Created by yaoqijun.
 * Date:2015-12-25
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class StringQueueSerializer implements QueueSerializer<String> {

    private static final Charset charset = Charset.forName("utf-8");

    @Override
    public byte[] serialize(String s) {
        return s.getBytes(charset);
    }

    @Override
    public String deserialize(byte[] bytes) {
        return new String(bytes,charset);
    }
}
