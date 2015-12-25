package org.yqj.original.demo.zookeeper.curator.transaction;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.Collection;

/**
 * Created by yaoqijun.
 * Date:2015-12-16
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class TransactionExamples {
    public static void main(String[] args) {
        System.out.println("Transaction test");
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1", retryPolicy);

        try{
            client.start();

            CuratorTransaction transaction = client.inTransaction();

            Collection<CuratorTransactionResult> results = transaction.create()
                    .forPath("/test/path", "some data".getBytes())
                    .and().setData().forPath("/test/path", "other data".getBytes())
                    .and().delete().forPath("/test/path")
                    .and().commit();

            for (CuratorTransactionResult result : results) {
                System.out.println(result.getForPath() + " - " + result.getType());
            }
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            CloseableUtils.closeQuietly(client);
            System.out.println("finish");
        }
    }
}
