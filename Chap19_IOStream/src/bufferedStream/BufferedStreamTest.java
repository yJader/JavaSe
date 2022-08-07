package bufferedStream;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-28 12:43
 * @Package bufferStream
 */
public class BufferedStreamTest {
    public static void main(String[] args) throws IOException {
        //1. 文件
        File srcFile = new File("Chap19_IOStream\\testFile\\mio.png");
        File desFile = new File("Chap19_IOStream\\testFile\\mio_copy2.png");

        //2. 流
        //节点流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);
        //缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //复制
        byte[] buffer = new byte[10];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        //先关闭外层的流, 再关闭内层的流
        //关闭外层流, 内层流会自动关闭
        bis.close(); bos.close();
        //fis.close(); fos.close();
    }
}
