package byteStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author yJade
 * @Date 2022-07-28 11:39
 * @Package byteStream
 */
public class FileInputStreamTest {
    public static void main(String[] args) {

    }
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try{
            File file = new File("testFile\\hello.txt");

            fis = new FileInputStream(file);

            //因为是字节流, 使用byte数组存储
            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
