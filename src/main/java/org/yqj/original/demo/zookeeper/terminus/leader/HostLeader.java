/*
 * Copyright (c) 2014 杭州端点科技网络有限公司
 */

package org.yqj.original.demo.zookeeper.terminus.leader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yqj.original.demo.zookeeper.terminus.HostNames;

/**
 * Author:  <a href="mailto:i@terminus.io">jlchen</a>
 * Date: 2014-09-01
 */
public class HostLeader {
    private final static Logger log = LoggerFactory.getLogger(HostLeader.class);

    private  final LeadLatchInitiator leadLatchInitiator;


    public HostLeader(){
        this(null);
    }

    /**
     * @param leadLatchInitiator  已经初始化过的leadLatch
     */
    public HostLeader(LeadLatchInitiator leadLatchInitiator) {

        this.leadLatchInitiator = leadLatchInitiator;
    }

    /**
     * 在初始化时调用此方法
     * @throws Exception, 如果连接zookeeper时失败, 抛出此异常
     */
    public void init() throws Exception {
        if (leadLatchInitiator != null) {
            leadLatchInitiator.init(HostNames.hostName);
        }
    }

    /**
     * 获取当前leader的id
     * @return 当前leader的id
     */
    public String currentLeaderId() {
        try {
            if (leadLatchInitiator != null) {
                return leadLatchInitiator.currentLeaderId();
            } else {
                return HostNames.hostName;
            }
        } catch (Exception e) {
            log.error("failed to get current leader id",e);
            return "unknown";
        }
    }

    /**
     * 判断当前host是否Leader
     * @return  当前host是否Leader
     */
    public boolean isLeader() {
        if (leadLatchInitiator == null) {
            return true;
        }
        try {
            return leadLatchInitiator.isLeader();
        } catch (Exception e) {
            log.error("oops, zookeeper failed,", e);
            return false;
        }
    }

    public void destroy() throws Exception {
        if (leadLatchInitiator != null) {
            leadLatchInitiator.close();
        }
    }
}
