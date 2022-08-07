package bufferedStream;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-28 17:22
 * @Package bufferedStream
 */
public class BufferedReaderWriterTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("Chap19_IOStream\\testFile\\copyTest_src.txt")));
            bw = new BufferedWriter(new FileWriter(new File("Chap19_IOStream\\testFile\\copyTest_des2.txt")));

            //方式一
            char[] buffer = new char[10];
            int len;
            while ((len = br.read(buffer)) != -1) {
                bw.write(buffer, 0, len);
            }
            //方式二
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
