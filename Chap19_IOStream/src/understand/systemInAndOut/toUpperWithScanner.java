package understand.systemInAndOut;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author yJade
 * @Date 2022-07-29 10:17
 * @Package systemInAndOut
 * 使用Scanner实现大小写转换
 */
public class toUpperWithScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str;
        while ((!(str = scanner.next()).equalsIgnoreCase("e")) && !str.equalsIgnoreCase("exit")) {
            System.out.println(str.toUpperCase());
        }
        System.out.println("已退出");
    }
}
