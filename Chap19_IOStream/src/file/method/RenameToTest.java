package file.method;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 15:52
 * @Package file.method
 */
public class RenameToTest {
    public static void main(String[] args) {
        File oldFile = new File("Chap19_IOStream\\testFile\\renameTest.txt");
        System.out.println(oldFile.getAbsolutePath());
        File newFile = new File("Chap19_IOStream\\testFile\\renameTest1.txt");
        System.out.println(newFile.getAbsolutePath());
        System.out.println(oldFile.renameTo(newFile));

        File oldFile1 = new File("Chap19_IOStream\\testFile\\renameFolder");
        System.out.println(oldFile1.getAbsolutePath());
        File newFile1 = new File("Chap19_IOStream\\testFile\\renameFolder1");
        System.out.println(newFile1.getAbsolutePath());
        System.out.println(oldFile1.renameTo(newFile1));

    }
}


