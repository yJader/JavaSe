package charStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author yJade
 * @Date 2022-07-28 9:50
 * @Package charStream
 */
public class FileWriterTest {
    public static void main(String[] args) {

    }

    @Test
    public void testFileWriter() throws IOException {
        //1. 提供File类的对象, 指名写出到的文件
        File file = new File("testFile\\FileWriterTest.txt");

        //2. 提供FileWriter的对象, 用于数据的写出
        FileWriter fw = new FileWriter(file, false);

//        fw.write("Hello\n");
//        fw.write("world");
        fw.write("12345");

        fw.close();


    }
}
