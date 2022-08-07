package byteStream;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-28 11:45
 * @Package byteStream
 */
public class CopyPictureTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1. 创建File对象
            File srcFile = new File("Chap19_IOStream\\testFile\\mio.png");
            System.out.println(srcFile.getAbsolutePath());
            System.out.println("isExist?" + srcFile.exists());
            File desFile = new File("Chap19_IOStream\\testFile\\mio_copy.png");

            //2. 创建流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            //3. 复制
            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    fos.write(buffer[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
