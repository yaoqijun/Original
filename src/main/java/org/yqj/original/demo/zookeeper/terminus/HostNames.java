package org.yqj.original.demo.zookeeper.terminus;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class HostNames {

    public static String hostName;

    static{
        String tempHostName = UUID.randomUUID().toString().substring(0, 6);
        try {
            tempHostName = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
        }
        hostName = tempHostName;
    }
}
