package file;

import java.io.File;
import java.io.IOException;

/**
 * @Author yJade
 * @Date 2022-07-27 18:22
 * @Package file
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        File file = new File("Chap19_IOStream\\testFile\\hello.txt");
        File file1 = new File(file.getParent(), "hi.txt");

        if (file1.createNewFile()) {
            System.out.println("创建成功");
        }
    }
}
