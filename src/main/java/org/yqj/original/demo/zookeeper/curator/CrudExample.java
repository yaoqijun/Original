package org.yqj.original.demo.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe: 增删改查操作
 */
public class CrudExample {

    private static final String PATH = "/crud";

    public static void main(String[] args) {
        System.out.println("crud example test");
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.28.138", retryPolicy);

        try{
            client.start();

//            client.create().forPath(PATH, "I love messi".getBytes());
//
//            byte[] bs = client.getData().forPath(PATH);
//            System.out.println("新建的节点，data为:" + new String(bs));

//            client.setData().forPath(PATH, "I love football".getBytes());

//            // 由于是在background模式下获取的data，此时的bs可能为null
//            byte[] bs2 = client.getData().watched().inBackground().forPath(PATH);
//            System.out.println("修改后的data为" + new String(bs2 != null ? bs2 : new byte[0]));
//
            client.delete().forPath(PATH);
            Stat stat = client.checkExists().forPath(PATH);

            // Stat就是对zonde所有属性的一个映射， stat=null表示节点不存在！
            System.out.println(stat);
            System.out.println("finish");
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println("exception finnish");
        }finally {
            CloseableUtils.closeQuietly(client);
            System.out.println("finish");
        }
    }
}
