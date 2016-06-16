package org.yqj.original.demo.dozer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2016-04-06
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private List<String> address;

}
