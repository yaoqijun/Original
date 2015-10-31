package org.yqj.original.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-31
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class TestMainTest {
    public static void main(String []args){
        System.out.println("test main class");
        List<String> testList = new ArrayList<>();
        testList.add("yao");
        System.out.println(testList.stream().map((f) -> "jun").toArray());
    }
}
