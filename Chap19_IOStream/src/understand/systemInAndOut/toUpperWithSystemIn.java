package understand.systemInAndOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author yJade
 * @Date 2022-07-29 10:22
 * @Package systemInAndOut
 * System.in实现
 */
public class toUpperWithSystemIn {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in); //转化为字符流
            br = new BufferedReader(isr);


            while (true) {
                System.out.println("请输入字符串");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
