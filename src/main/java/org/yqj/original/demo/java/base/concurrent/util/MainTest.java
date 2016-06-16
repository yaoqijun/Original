package org.yqj.original.demo.java.base.concurrent.util;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by yaoqijun.
 * Date:2016-03-19
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("test condition");

//        System.out.println("test concurrent map content");
//        ConcurrentMap<String,Integer> testMap = new ConcurrentHashMap<>();
//        testMap.put("test",1);
//        testMap.put("test1",2);
//        System.out.println(testMap.get("test"));

        System.out.println("navigable table content");
        ConcurrentNavigableMap<String, String> concurrentNavigableMap =
                new ConcurrentSkipListMap<>();
        concurrentNavigableMap.put("1","one");
        concurrentNavigableMap.put("2","two");
        concurrentNavigableMap.put("3","three");
        System.out.println(concurrentNavigableMap.headMap("2").toString());
        System.out.println(concurrentNavigableMap.tailMap("2").toString());
        System.out.println(concurrentNavigableMap.subMap("1","2").toString());

    }
}
