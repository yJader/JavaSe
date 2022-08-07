package file.method;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 15:36
 * @Package file.method
 */
public class GetTest02 {
    public static void main(String[] args) {
        File file = new File("Chap19_IOStream");
//        File file = new File("D:\\Java\\idea_workspace\\books\\JavaSe_hsp\\Chap19_IOStream");
        System.out.println(file.getAbsolutePath());

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }
        System.out.println();

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }
}
