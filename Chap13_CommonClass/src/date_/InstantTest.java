package date_;

import java.time.Instant;
import java.util.Date;

public class InstantTest {
    public static void main(String[] args) {
        //通过静态方法now() 获取表示当前时间戳的对象
		Instant now = Instant.now();
        System.out.println(now);
        //用from方法将Instant转换为Date
        Date date = Date.from(now);
        //用date的toInstant()方法将date转换为Instant对象
        Instant instant = date.toInstant();
    }
}
