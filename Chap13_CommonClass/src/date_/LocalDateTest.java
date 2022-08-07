package date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
        //用now()方法返回当前日期/时间的对象
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);    //2022-06-22T16:31:43.232888500

        //使用DateTimeFormatter对象来格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dateTimeFormatter.format(ldt));
        //也可以自己组合
        System.out.println("年" + ldt.getYear());
        System.out.println("月" + ldt.getMonth());
        System.out.println("日" + ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getDayOfYear());

        //还提供了plus和minus方法对时间进行加减
        LocalDateTime ldt2 = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(ldt2));
        System.out.println("12345678分钟前=" + dateTimeFormatter.format(ldt.minusMinutes(12345678)));
    }
}
