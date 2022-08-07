package file.method;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author yJade
 * @Date 2022-07-27 16:42
 * @Package file.method
 */
public class CreateAndDeleteTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("Chap19_IOStream\\testFile\\createTest.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test(){
        //文件目录的创建
        File file1 = new File("Chap19_IOStream\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("Chap19_IOStream\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("Chap19_IOStream\\io\\io1\\io4");
        file3 = new File("Chap19_IOStream\\io\\io1");
        System.out.println(file3.delete());
    }
}


