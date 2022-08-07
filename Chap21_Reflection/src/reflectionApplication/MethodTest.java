package reflectionApplication;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author yJade
 * @Date 2022-08-03 21:52
 * @Package reflectionApplication
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        //getMethods() : 获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m.toString());
        }

        System.out.println("--------------");

        //getDeclaredMethods() :
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m.toString());
        }
    }

    /*
    @Xxx
    权限修饰符 返回值类型 方法名(参数类型1 形参名1, ....) throws XxxException{}
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method m : declaredMethods) {
            System.out.println("-------------\n" + m);
            //1. 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a:
                 annotations) {
                System.out.println("注解: " + a);
            }

            //2. 权限修饰符
            System.out.println("权限: " + Modifier.toString(m.getModifiers())); //返回的也是int

            //3. 返回值类型
            System.out.println("返回值类型: " + m.getReturnType().getName()); //没有getName的话,返回的类型名是带包名的

            //4.方法名
            System.out.println("方法名: " + m.getName());

            //5. 形参列表
            Class[] parameterTypes = m.getParameterTypes();
            System.out.print("形参列表: (");
            if (parameterTypes.length != 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i != 0) System.out.printf(", ");
                    System.out.printf(parameterTypes[i].getName() + " args_" + i);
                }
            }
            System.out.println(")");

            //6. 抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            System.out.printf("异常列表: {");
            if (exceptionTypes.length != 0) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i != 0) System.out.printf(", ");
                    System.out.printf(exceptionTypes[i].getName() + " args_" + i);
                }
            }
            System.out.println("}");
        }
    }
}
