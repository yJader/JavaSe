package objectStream;

//import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author yJade
 * @Date 2022-07-29 22:47
 * @Package objectStream
 */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程: 将内存中的java对象保存到磁盘/通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            //.dat是为了让输出不能直接查看, 表示存储的是一个对象而非文本
            oos = new ObjectOutputStream(new FileOutputStream("testFile\\object.dat"));

            oos.writeObject(new String("走在未知的路上, 不许停也不能回头"));
            oos.flush(); //刷新操作

            oos.writeObject(new Person("joker", 19, true));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 反序列化: 将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInpStream实现
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("testFile\\object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            System.out.println(ois.readObject().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
