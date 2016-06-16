package org.yqj.original.demo.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Created by yaoqijun.
 * Date:2016-03-06
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class CollectionTest {
    public static void main(String[] args) {
        System.out.println("collection test condition all");

        //multiSet user method
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("yao");
        multiset.add("qi");
        multiset.add("jun");
        multiset.add("yao");
        multiset.add("jun");
        multiset.add("yao");
        System.out.println(multiset.toString());


    }
}
