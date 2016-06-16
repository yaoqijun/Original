package org.yqj.original.demo.jodatime.doc;

import org.joda.time.DateTime;

/**
 * Created by yaoqijun.
 * Date:2016-04-10
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(" main test condition ");

        //Date time content
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.monthOfYear().getAsText());
        System.out.println(dateTime.dayOfMonth().roundFloorCopy().toString());
    }
}
