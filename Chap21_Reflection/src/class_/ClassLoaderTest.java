package class_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author yJade
 * @Date 2022-08-02 21:01
 * @Package class_
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    @Test
    public void test3(){
        Properties pros1 = new Properties();
        //读取配置文件的方式一：
        //此时的文件默认在当前的module下。
        FileInputStream fis = null;
        try {
//            fis = new FileInputStream("jdbc.properties");
            fis = new FileInputStream("src\\jdbc1.properties");
            pros1.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String user1 = pros1.getProperty("user");
        String password1 = pros1.getProperty("password");
        System.out.println("user = " + user1 + ", password = " + password1);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        Properties pros2 = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        try {
            pros2.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user2 = pros2.getProperty("user");
        String password2 = pros2.getProperty("password");
        System.out.println("user = " + user2 + ", password = " + password2);
    }
}
