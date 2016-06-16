package org.yqj.original.demo.dozer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerConverter;

import java.util.List;
import java.util.Map;

/**
 * Created by yaoqijun.
 * Date:2016-04-06
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) {
        DozerBeanMapper doz = new DozerBeanMapper();
        Map<String,Object> context = Maps.newHashMap();
        doz.setCustomConverters(Lists.newArrayList(new MyConvert(List.class,Object.class)));
        Person p = Person.builder().name("yaoqijun").age(18).address(Lists.newArrayList("1","2")).build();
        doz.map(p,context);
        System.out.println(context.toString());
    }

    public static class MyConvert extends DozerConverter<List,Object> {

        /**
         * Defines two types, which will take part transformation.
         * As Dozer supports bi-directional mapping it is not known which of the classes is source and
         * which is destination. It will be decided in runtime.
         *
         * @param prototypeA type one
         * @param prototypeB type two
         */
        public MyConvert(Class<List> prototypeA, Class<Object> prototypeB) {
            super(prototypeA, prototypeB);
        }

        @Override
        public Object convertTo(List source, Object destination) {
            return source;
        }

        @Override
        public List convertFrom(Object source, List destination) {
            return (List) source;
        }
    }

}
