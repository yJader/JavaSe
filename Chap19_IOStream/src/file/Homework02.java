package file;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 18:27
 * @Package file
 */
public class Homework02 {
    public static void main(String[] args) {
        File file = new File("E:\\Pictures");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());

        String[] fileNames = file.list();
        for (String fileName: fileNames) {
            if (fileName.endsWith(".jpg")) {
                System.out.println(fileName);
            }
        }

    }
}
