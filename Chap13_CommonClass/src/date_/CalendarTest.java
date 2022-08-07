package date_;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();     //创建日历对象
        //获取日历对象的某个日历字段
        System.out.println("年: " + c.get(Calendar.YEAR));
        System.out.println("月: " + (c.get(Calendar.MONTH) + 1));
        System.out.println("日: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时: " + c.get(Calendar.HOUR));
        System.out.println("分钟: " + c.get(Calendar.MINUTE));
        System.out.println("秒: " + c.get(Calendar.SECOND));
        //Calendar没有专门的格式化, 需要自己手动组合
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
    }
}
