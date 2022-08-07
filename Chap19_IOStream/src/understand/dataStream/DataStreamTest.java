package understand.dataStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-29 15:12
 * @Package understand.dataStream
 *
 */
public class DataStreamTest {
    //使用DataOutPutStream将内存中的字符串, 基本数据类型的变量写入到文件中
    @Test
    public void testDataOutputStream() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("testFile\\dataOutputStreamTest.txt"));

            dos.writeUTF("joker 雨宫莲");
            dos.flush();
            dos.writeInt(19);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    //注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
    @Test
    public void test4() {
        DataInputStream dis = null;
        try {
            //1.造对象、造流
            dis = new DataInputStream(new FileInputStream("testFile\\dataOutputStreamTest.txt"));
            //2.从文件读入数据
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("isMale:" + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
