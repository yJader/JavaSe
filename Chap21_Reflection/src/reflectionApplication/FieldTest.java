package reflectionApplication;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author yJade
 * @Date 2022-08-03 15:46
 * @Package reflectionApplication
 *
 * 获取当前运行时类的属性结构
 */
public class FieldTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        //获取属性结构
        //getFields(): 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        /*
          public int reflectionApplication.Person.id
          public double reflectionApplication.Creature.weight
          只有这两个属性是public
         */

        //getDeclaredFields(): 获取当前运行时类的所有属性(不包括父类的属性)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        /*
        private java.lang.String reflectionApplication.Person.name
        int reflectionApplication.Person.age
        public int reflectionApplication.Person.id
        获取到
         */
    }

    //获取属性的 权限修饰符 数据类型 变量名 静态属性的变量值
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("---------------------");
            System.out.println(f);
            //1. 权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //default类型toString后为空

            //2. 数据类型
            Class<?> type = f.getType();
            System.out.println(type);

            //3. 变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
