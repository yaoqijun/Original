package org.yqj.original.demo.lombok.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString   //toString gender toString method
@EqualsAndHashCode  //equals hashCode content
public class Student implements Serializable {

    private String name;

    private Integer age;

    private Float grage;

    private Boolean gender;
}
