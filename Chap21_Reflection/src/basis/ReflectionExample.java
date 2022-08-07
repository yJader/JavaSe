package basis;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author yJade
 * @Date 2022-08-01 11:05
 * @Package basis
 */
public class ReflectionExample {
    //不使用反射, 对于Person的各种操作
    @Test
    public void test1() throws Exception {
        //1. new创建Person类对象
        Person joker = new Person("Joker", 19);

        //2. 通过对象调用其内部属性和方法
        joker.age++;
        System.out.println(joker.toString());

        joker.show();
        //在Person类外部, 不能够Person类的对象调用其内部私有结构
        // 如: 私有属性name, 私有方法showNation(), 以及私有的构造器
    }

    //使用反射对Person操作
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //1. 通过反射创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("joker", 19);
        Person joker = (Person) obj;
        System.out.println(joker.toString());

        //2. 通过反射调用其内部属性和方法
        //调用属性age
        Field age = clazz.getDeclaredField("age");
        age.set(joker, 10);
        System.out.println(joker);

        //调用show方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(joker);

        //3. 通过反射, 可以访问私有结构
        //私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object obj1 = cons1.newInstance("mona");
        Person mona = (Person) obj1;
        System.out.println(mona);
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(mona, "Morgana");
        System.out.println(mona);
        //私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(mona, "霓虹");//相当于mona.showNation()
        System.out.println(nation);
    }

    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式1. 调用一个运行时类的属性.class
        Class clazz1 = Person.class;
        System.out.println("方式1. 调用一个运行时类的属性: Person.class : " + clazz1); //basis.Person
        
        //方式2. 通过运行时类的对象
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println("方式2. 通过运行时类的对象: person.getClass(): " + clazz2); //basis.Person

        //方式3. 调用Class的静态方法: forName(String classPath)
        Class clazz3 = Class.forName("basis.Person");
        System.out.println("方式3. 调用Class的静态方法: forName(String classPath): " + clazz3); //basis.Person

        System.out.println(clazz1 == clazz2); //true
        System.out.println(clazz1 == clazz3); //true

        //方式4. 使用类的加载器: ClassLoader() (仅了解)
        ClassLoader classLoader = ReflectionExample.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("basis.Person");
        System.out.println(clazz4); //basis.Person
        System.out.println(clazz4 == clazz1); //true
    }
}

