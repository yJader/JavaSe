package transfromIO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-28 23:17
 * @Package transfromIO
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Chap19_IOStream\\testFile\\dbcp_UTF-8.txt"); //使用参数为String的构造器
        //InputStreamReader isr = new InputStreamReader(file); //使用系统默认字符集
        //参数2指名字符集, 但具体应该用哪个字符集, 应该取决于源文件(dbcp_UTF-8.txt)保存时的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] charBuffer = new char[10];
        int len;
        while ((len = isr.read(charBuffer)) != -1) {
            String str = new String(charBuffer, 0, len);
            System.out.print(str);
        }
        isr.close();
    }

    //综合使用InputStreamReader和OutputStreamWriter
    @Test
    public void test() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            FileInputStream fis = new FileInputStream("testFile\\dbcp_UTF-8.txt"); //使用参数为String的构造器
            FileOutputStream fos = new FileOutputStream("testFile\\dbcp_gbk.txt"); //使用参数为String的构造器
            isr = new InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "gbk");

            char[] charBuffer = new char[10];
            int len;
            while ((len = isr.read(charBuffer)) != -1) {
                osw.write(charBuffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            FileInputStream fis = new FileInputStream("testFile\\dbcp_gbk.txt"); //使用参数为String的构造器
            FileOutputStream fos = new FileOutputStream("testFile\\dbcp_UTF-8.txt"); //使用参数为String的构造器
            isr = new InputStreamReader(fis, "gbk");
            osw = new OutputStreamWriter(fos, "UTF-8");

            char[] charBuffer = new char[10];
            int len;
            while ((len = isr.read(charBuffer)) != -1) {
                osw.write(charBuffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
