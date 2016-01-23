package org.yqj.original.demo.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

/**
 * Created by yaoqijun.
 * Date:2016-01-06
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
        Handlebars handlebars = new Handlebars();

        Template template = handlebars.compileInline("Hello {{this}}!");

        System.out.println(template.apply("Handlebars.java"));
    }
}
