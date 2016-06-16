package org.yqj.original.demo.guava;

/**
 * Created by yaoqijun.
 * Date:2016-03-05
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("test content");
        // Optional
//        Optional<Integer> optional = Optional.of(5);
//        System.out.println(optional.isPresent());
//        System.out.println(optional.get());

        //more objects
//        System.out.println(MoreObjects.toStringHelper(MainTest.class)
//                .add("test","1").add("hh",2.3123).add("123",null).add("hehe","123").add("66",null).toString());

        //strings 获取对应字符串类型
//        System.out.println(Strings.padStart("yaoqijun",10,'H'));
//        System.out.println(Strings.padEnd("yaoqijun",10,'F'));

        //precondition
//        try{
//            Integer t = 100;
//            Preconditions.checkArgument(t<100, "test condition %s", t);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        Integer test = 1000;
//        System.out.println(Preconditions.checkNotNull(test));

        //Compare
//        System.out.println(Integer.compare(1, 100));
//        System.out.println(ComparisonChain.start()
//                .compare(10,10)
//                .compare(9,10).result());

        //ordering
//        Ordering<Integer> ordering = Ordering.natural().nullsLast();

        //Throwables
//        try{
//            throw new Exception("test");
//        }catch (Exception e){
//            Throwables.getStackTraceAsString(e);
//        }
    }
}
