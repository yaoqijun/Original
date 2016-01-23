package org.yqj.original.demo.lombok;

import org.yqj.original.demo.lombok.model.BuilderTest;
import org.yqj.original.demo.lombok.model.Student;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) {
        BuilderTest builderTest = new BuilderTest();
        System.out.println(builderTest.getName());  //public getter field

        Student student = new Student("yaoqijun",10,12.1f,Boolean.TRUE);
        System.out.println(student.toString());
        System.out.println(student.hashCode());

        Student student1 = new Student("yaoqijun",10,12.1f,Boolean.TRUE);
        System.out.println(student1.hashCode());
        System.out.println(student.equals(student1));
    }
}
