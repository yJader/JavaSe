package file.method;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @Author yJade
 * @Date 2022-07-27 13:59
 * @Package file.method
 */

public class GetTest01 {
    public static void main(String[] args) {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Java\\idea_workspace\\books\\JavaSe_hsp\\Chap19_IOStream\\testFile\\hello.txt");
        File file3 = new File("src\\file\\method\\hi.txt");

        System.out.println("--以相对路径构造的file1--");
        System.out.println(file1.getAbsolutePath()); //获取绝对路径
        System.out.println(file1.getPath()); //获取与构造器相同的路径
        System.out.println(file1.getName()); //获取名称
        System.out.println(file1.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file1.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file1.lastModified()); //获取最后一次的修改时间，毫秒值

        System.out.println("--以绝对路径构造的file2--");
        System.out.println(file2.getAbsolutePath()); //获取绝对路径
        System.out.println(file2.getPath()); //获取与构造器相同的路径
        System.out.println(file2.getName()); //获取文件名
        System.out.println(file2.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file2.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file2.lastModified()); //获取最后一次的修改时间，毫秒值

        System.out.println("--附加测试--");
        System.out.println(file3.getAbsolutePath()); //获取绝对路径
        System.out.println(file3.getPath()); //获取与构造器相同的路径
        System.out.println(file3.getName()); //获取文件名
        System.out.println(file3.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file3.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file3.lastModified()); //获取最后一次的修改时间，毫秒值
    }

    @Test
    void test() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Java\\idea_workspace\\books\\JavaSe_hsp\\Chap19_IOStream\\hello.txt");
        File file3 = new File("src\\file\\method\\hi.txt");

        System.out.println("--以相对路径构造的file1--");
        System.out.println(file1.getAbsolutePath()); //获取绝对路径
        System.out.println(file1.getPath()); //获取与构造器相同的路径
        System.out.println(file1.getName()); //获取名称
        System.out.println(file1.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file1.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file1.lastModified()); //获取最后一次的修改时间，毫秒值

        System.out.println("--以绝对路径构造的file2--");
        System.out.println(file2.getAbsolutePath()); //获取绝对路径
        System.out.println(file2.getPath()); //获取与构造器相同的路径
        System.out.println(file2.getName()); //获取文件名
        System.out.println(file2.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file2.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file2.lastModified()); //获取最后一次的修改时间，毫秒值

        System.out.println("--附加测试--");
        System.out.println(file3.getAbsolutePath()); //获取绝对路径
        System.out.println(file3.getPath()); //获取与构造器相同的路径
        System.out.println(file3.getName()); //获取文件名
        System.out.println(file3.getParent()); //获取上层文件目录路径. 若无，返回 null
        System.out.println(file3.length()); //获取文件长度（即：字节数）不能获取目录的长度。
        System.out.println(file3.lastModified()); //获取最后一次的修改时间，毫秒值
    }
}
