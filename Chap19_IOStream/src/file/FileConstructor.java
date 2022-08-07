package file;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-26 23:42
 * @Package file
 */
public class FileConstructor {
    public static void main(String[] args) {
        //构造器1
        File file1 = new File("hello.txt"); //相对于当前的module
        File file2 = new File("D:\\Java\\idea_workspace\\books\\JavaSe_hsp\\Chap19_IOStream\\testFile\\hello.txt");
        System.out.println("file1: " + file1);
        System.out.println("file2: " + file2);

        //构造器2
        File file3 = new File("D:\\Java\\idea_workspace\\books\\JavaSe_hsp\\Chap19_IOStream\\testFile", "hello.txt");
        System.out.println("file3: " + file3);

        //构造器3
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);
    }
}
