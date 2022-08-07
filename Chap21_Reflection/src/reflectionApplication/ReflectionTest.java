package reflectionApplication;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author yJade
 * @Date 2022-08-03 23:46
 * @Package reflectionApplication
 */
public class ReflectionTest {

    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        //调用非静态属性, 需要先创建运行时类的对象
        Person person = personClass.newInstance();

        //获取指定的属性 要求: 该属性声明为public
        //所以 通常不采用瓷方式
        Field id = personClass.getField("id");
//        java.lang.NoSuchFieldException: name
//        Field name = personClass.getField("name"); //无法获取私有成员name, 抛异常
//        Field name = personClass.getField("age"); //无法获取成员age, 抛异常


        //设置当前属性的值
        //set(): 参数1: 指名设置的是那应该对象的属性; 参数2: 将此属性设置为多少
//        id.set(person, 100);

        //获取当前属性的值 default: -1(自己设置的)
        int pId =(int) id.get(person);
        System.out.println(pId);
    }

    //如何操作指定运行时类的属性
    @Test
    public void testField1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        //调用非静态属性, 需要先创建运行时类的对象
        Person person = personClass.newInstance();

        Field name = personClass.getDeclaredField("name");

        name.setAccessible(true);
//        否则抛异常:
//        java.lang.IllegalAccessException: Class reflectionApplication.
//        ReflectionTest can not access a member of class reflectionApplication.
//        Person with modifiers "private"
        name.set(person, "panther");

        System.out.println(name.get(person));
        System.out.println(person);
    }

    //如何操作运行时类中的指定的方法
    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        //获取运行时类对象
        Person person = personClass.newInstance();

        //1. 获取指定的某个方法
        //getDeclaredMethod() : 参数1: 指名获取的方法的名称; 参数2: 指名获取的方法的形参列表
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);

        //2. 保证方法可访问
        showNation.setAccessible(true);

        //调用方法的invoke方法
        //invoke() : 参数1: 方法的调用者(对象); 参数2: 给方法形参赋值的实参
        Object returnValue = showNation.invoke(person, "CHN");
        System.out.println(returnValue);

        System.out.println("******如何调用静态方法*******");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //无返回值的运行时类的方法, invoke返回null
        Object returnValue1 = showDesc.invoke(Person.class);
        System.out.println(returnValue1);
        Object returnValue2 = showDesc.invoke(person);
        System.out.println(returnValue2);
        Object returnValue3 = showDesc.invoke(null);
        System.out.println(returnValue3);
    }

}
