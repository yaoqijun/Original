package org.yqj.original.demo.lombok.model;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

import java.io.Serializable;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Value
public class Teacher implements Serializable {

    @Wither(AccessLevel.PUBLIC)
    @NonFinal
    private String name;

    private Integer age;

    private Float count;

    private Boolean gender;
}
