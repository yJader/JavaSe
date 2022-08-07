package reflectionApplication;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author yJade
 * @Date 2022-08-03 23:24
 * @Package reflectionApplication
 */
public class OtherTest {
    Class<Person> personClass = Person.class;
    /*
    获取运行时类的构造器结构
     */
    @Test
    public void test1() {
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){

        Class superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
   获取运行时类的带泛型的父类
    */
    @Test
    public void test3(){
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类的 带泛型的父类 的泛型
    代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void test4(){
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6(){
        Package pack = personClass.getPackage();
        System.out.println(pack);
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Annotation[] annotations = personClass.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
