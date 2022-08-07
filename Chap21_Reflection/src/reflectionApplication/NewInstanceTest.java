package reflectionApplication;

import basis.Person;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author yJade
 * @Date 2022-08-02 21:16
 * @Package reflectionApplication
 * 通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        //newInstance():调用此方法, 创建对应的运行时类的对象
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    @Test
    public void test2(){

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "basis.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj.getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个指定类的对象。
     * classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz =  Class.forName(classPath);
        return clazz.newInstance();
    }
}