package file;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 18:33
 * @Package file
 */
public class Homework03 {
    public static void main(String[] args) {
        File file = new File("E:\\Pictures");
        printFiles(file);
    }

    public static void printFiles(File srcFile) {
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.getName().equals("bili")) continue;
            if (file.isDirectory()) {
                printFiles(file);
            } else {
                System.out.println(file.getPath());
            }
        }
    }
}

