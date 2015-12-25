package org.yqj.original.demo.zookeeper.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ZooKeeperOperator extends AbstractZooKeeper {

    public void create(String path,byte[] data)throws KeeperException, InterruptedException{
        this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public void getChild(String path) throws KeeperException, InterruptedException{
        try{
            List<String> list=this.zooKeeper.getChildren(path, false);
            if(list.isEmpty()){
                System.out.println(path + "中没有节点");
            }else{
                System.out.println(path+"中存在节点");
                for(String child:list){
                    System.out.println("节点为："+child);
                }
            }
        }catch (KeeperException.NoNodeException e) {
            // TODO: handle exception
            throw e;
        }
    }

    public byte[] getData(String path) throws KeeperException, InterruptedException {
        return  this.zooKeeper.getData(path, false,null);
    }

    public static void main(String[] args) {
        try{
            System.out.println("test zookeeper content");
            ZooKeeperOperator zooKeeperOperator = new ZooKeeperOperator();
            zooKeeperOperator.connect("192.168.28.138");

            byte[] data = new byte[]{'a','b','c','d'};

            zooKeeperOperator.create("/crud",null);
            System.out.println(Arrays.toString(zooKeeperOperator.getData("/test")));

//            zooKeeperOperator.create("/test/child1",data);
//            System.out.println(Arrays.toString(zooKeeperOperator.getData("/test/child1")));

//            zooKeeperOperator.create("/test/child2",data);
//            System.out.println(Arrays.toString(zooKeeperOperator.getData("/test/child2")));

//            System.out.println("child info ---------------------------------------------");
//            zooKeeperOperator.getChild("/test");
//            System.out.println("child info ---------------------------------------------");

            zooKeeperOperator.close();
            System.out.println("test zookeeper finish");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("exception");
        }
    }
}
