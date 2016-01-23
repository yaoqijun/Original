package org.yqj.original.demo.lombok.model;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Created by yaoqijun.
 * Date:2016-01-23
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class BuilderTest {

    @Getter(AccessLevel.PUBLIC)     //ok now definition range of
    private String name;

    @Getter(AccessLevel.PROTECTED)
    private Integer age;

    @Getter(AccessLevel.PACKAGE)
    private Float grade;

    @Getter(AccessLevel.PRIVATE)
    private Boolean general;
}
