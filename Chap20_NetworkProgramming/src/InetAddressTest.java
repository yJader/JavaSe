import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author yJade
 * @Date 2022-07-30 19:37
 * @Package inetAddress
 */
public class InetAddressTest {
    public static void main(String[] args) {
        long begin, end;
        try {
            begin = System.currentTimeMillis();
            InetAddress inet1 = InetAddress.getByName("192.168.0.0");
            end = System.currentTimeMillis();
            System.out.println(inet1);
            System.out.println("用时" + (end - begin));

            begin = System.currentTimeMillis();
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            end = System.currentTimeMillis();
            System.out.println(inet2);
            System.out.println("用时" + (end - begin));

            //获取本地ip
            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);
            System.out.println(InetAddress.getLocalHost());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
