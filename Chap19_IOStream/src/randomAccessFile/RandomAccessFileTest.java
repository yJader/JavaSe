package randomAccessFile;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author yJade
 * @Date 2022-07-30 13:53
 * @Package randomAccessFile
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("testFile\\mio.png"), "r");
            raf2 = new RandomAccessFile(new File("testFile\\mio_raf.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Test
    public void test2(){
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("hello.txt"), "rw");

            raf1.seek(3);//将指针调到角标为3的位置
            //方式一
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
//            byte[] buffer = new byte[20];
//            int len;
//            while ((len = raf1.read(buffer)) != -1){
//                builder.append(new String(buffer,0,len));
//            }

            //方式二
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            //调回指针，写入“xyz”
            raf1.seek(3);
            raf1.write("xyz".getBytes());
            //将StringBuilder中的数据写入到文件中
            raf1.write(baos.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
