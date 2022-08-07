package file.method;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 16:43
 * @Package file.method
 */
public class JudgeTest {
    public static void main(String[] args) {
        File file1 = new File("Chap19_IOStream\\testFile\\Hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println("exists? " + file1.exists());
        System.out.println("isFile? " + file1.isFile());
        System.out.println("isDirectory? " + file1.isDirectory());
        System.out.println("canRead? " + file1.canRead());
        System.out.println("canWrite? " + file1.canWrite());
        System.out.println("isHidden? " + file1.isHidden());
        System.out.println();

        File file2 = new File("Chap19_IOStream");
        System.out.println(file2.getAbsolutePath());
        System.out.println("exists? " + file2.exists());
        System.out.println("isFile? " + file2.isFile());
        System.out.println("isDirectory? " + file2.isDirectory());
        System.out.println("canRead? " + file2.canRead());
        System.out.println("canWrite? " + file2.canWrite());
        System.out.println("isHidden? " + file2.isHidden());
    }
}
