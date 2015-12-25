/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.pubsub;

import com.google.common.io.Files;
import org.yqj.original.demo.zookeeper.terminus.HostNames;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-02
 */
public class Paths {

    /**
     * The subscriber creates an ephemeral node with its subscriber ID under  /[basePath]/clients.
     * This is used by the cleaner to remove message for disconnected subscriber.
     */
    private final String clientBase;

    /**
     * The subscriber creates an ephemeral node with its subscriber ID under  /[basePath]/subscribers/[topic]
     */
    private final String subscriberBase;


    /**
     * The subscriber creates a watcher on /[basePath]/topics/[topic]/[consumerID].
     * The publisher will update the data of this node.
     */
    private final String topicBase;

    public Paths(String basePath, String topic) {
        clientBase = Files.simplifyPath(basePath + "/clients");

        subscriberBase = basePath + "/subscribers/" + topic;

        topicBase = basePath + "/topics/" + topic;

    }

    public String getClientBase() {
        return clientBase;
    }


    public String getClientPathOfLocalhost() {
        return  Files.simplifyPath(clientBase+"/"+HostNames.hostName);
    }


    public String getSubscriberBase() {
        return subscriberBase;
    }

    public String getSubscriberPathOfLocalhost() {
        return Files.simplifyPath(subscriberBase + "/" + HostNames.hostName);
    }

    public String getTopicBase() {
        return topicBase;
    }

    public String getTopicPathOfLocalHost() {
        return getTopicPathOfHost(HostNames.hostName);
    }

    public String getTopicPathOfHost(String hostName){
        return Files.simplifyPath(topicBase+"/"+hostName);
    }
}
