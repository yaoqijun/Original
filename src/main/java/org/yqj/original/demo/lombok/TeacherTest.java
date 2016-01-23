package org.yqj.original.demo.lombok;

import org.yqj.original.demo.lombok.model.Teacher;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class TeacherTest {
    public static void main(String[] args) {
        System.out.println("this is teacher test content");
        Teacher teacher = new Teacher("yaoqijun",12,12.12f,Boolean.TRUE);
        System.out.println(teacher.toString());
        System.out.println(teacher.hashCode());
        System.out.println(teacher.equals(new Object()));
        System.out.println(teacher.getName());
    }
}
