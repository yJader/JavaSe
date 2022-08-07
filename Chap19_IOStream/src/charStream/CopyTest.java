package charStream;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @Author yJade
 * @Date 2022-07-28 10:06
 * @Package charStream
 */
public class CopyTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            File srcFile = new File("Chap19_IOStream\\testFile\\copyTest_src.txt");
            File desFile = new File("Chap19_IOStream\\testFile\\copyTest_des.txt");
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(desFile);

            char[] chBuffer = new char[10]; //字符缓存
            int len;
            while ((len = fileReader.read(chBuffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    fileWriter.write(chBuffer[i]);
                }
            }
            fileWriter.write("\n"+ LocalDateTime.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
