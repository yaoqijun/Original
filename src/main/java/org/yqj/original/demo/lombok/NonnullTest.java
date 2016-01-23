package org.yqj.original.demo.lombok;

import lombok.NonNull;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class NonnullTest {

    public static void main(String[] args) {
        testNull("yaoqijun");
        try{
            testNull(null);
        }catch (Exception e){
            System.out.println("null exception");
        }
    }

    public static void testNull(@NonNull String testStr){
        System.out.println("this is test string"+testStr);
    }

}
