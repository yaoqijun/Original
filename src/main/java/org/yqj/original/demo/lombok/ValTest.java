package org.yqj.original.demo.lombok;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ValTest {
    public static void main(String[] args) {
        val test = new ArrayList<>();   // 默认final 集合的类型 不做限定
        test.add("yaoqijun");
        test.add(123);
        test.add(Boolean.TRUE);
        test.add(123.3123f);
        test.forEach(System.out::println);

        val map = new HashMap<Integer,String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            //System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());    //complie error but run ok cool
        }
    }
}
