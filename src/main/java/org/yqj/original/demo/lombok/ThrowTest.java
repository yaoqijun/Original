package org.yqj.original.demo.lombok;

import lombok.SneakyThrows;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ThrowTest {
    public static void main(String[] args) {
        System.out.println("test throw");
        try{
            throwContent();
        }catch (Exception e){
            System.out.println(e.getClass().getName());
        }
    }

    @SneakyThrows(RuntimeException.class)
    public static void throwContent(){
        System.out.println(1/0);
    }
}
