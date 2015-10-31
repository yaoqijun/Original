package org.yqj.original.demo;

import java.util.function.Function;

/**
 * Created by yaoqijun.
 * Date:2015-10-31
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String []args){
        System.out.println("main test printf");
        Function<String,Integer> function = (str) -> Integer.valueOf(str);
        System.out.println(function.apply("123")+100);
    }
}
