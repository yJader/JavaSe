package charStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author yJade
 * @Date 2022-07-27 23:13
 * @Package io
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            //1.实例化File对象
            File file1 = new File("testFile\\hello.txt");

            //2. 提供具体的流
            fileReader = new FileReader(file1);

            //3. 数据的读入
            //read(): 返回读入的一个字符, 达到末尾则返回-1
            System.out.println("输出" + file1.getAbsolutePath());
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //为保证发生异常后, 依然会关闭流资源, 需要使用try-catch-finally处理异常
            //4. 流的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //对read()操作升级, 使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("testFile\\hello.txt");

            fr = new FileReader(file);

            //每一次返回charBuffer数组中字符的个数, 如果达到文件末尾, 返回-1
            char[] charBuffer = new char[5];
            int len;
            while ((len = fr.read(charBuffer)) != -1) {
                //方式1 数组直接输出
    //            for (int i = 0; i < len; i++) {
    //                System.out.print(charBuffer[i]);
    //            }
                //方式2 转化为String
                String str = new String(charBuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
