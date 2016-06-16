package org.yqj.original.demo.jodatime.doc;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;

/**
 * Created by yaoqijun.
 * Date:2016-04-10
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class IntervalTest {
    public static void main(String[] args) {
        System.out.println("test interval condition");

        DateTime begin = DateTime.now().minusYears(1);
        DateTime end = DateTime.now();

        Interval interval = new Interval(begin, end);

        // test interval condition
        // to Chronology info
//        Chronology chronology = interval.getChronology();
//        System.out.println(chronology.getZone().toString());

        // time millions
//        System.out.println(interval.toDurationMillis());

        // Durintion
        Duration duration = interval.toDuration();
        System.out.println(duration.getStandardHours());

        Period period = interval.toPeriod();
        System.out.println(period.getSeconds());
    }

    private void testCondition(){
        return;
    }
}
