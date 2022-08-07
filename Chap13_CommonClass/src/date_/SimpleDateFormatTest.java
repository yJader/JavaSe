package date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Date date1 = new Date();     //获取当前系统时间
        Date date2 = new Date(1003939200000L);    //按指定毫秒数得到时间
        System.out.println(date2);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEEE");
        System.out.println(sdf.format(date1));
        //解析文本
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2001年10月25日 我也不知道具体时间";
        try{
            Date parse = sdf2.parse(str);
            System.out.println(parse.getTime());
        } catch (ParseException parseException) {
            System.out.println("日期格式错误");
        }


    }
}
