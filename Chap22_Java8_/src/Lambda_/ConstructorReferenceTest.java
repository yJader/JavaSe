package Lambda_;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author yJade
 * @Date 2022-08-06 9:57
 * @Package Lambda_
 */
public class ConstructorReferenceTest {
    //构造器引用
    //利用Supplier中的T get(), 获取一个Employee实例
    @Test
    public void test1() {
        //使用匿名内部类
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        //使用Lambda表达式
        System.out.println("====================");
        Supplier<Employee> sup1 = () -> new Employee(1001, "Tom", 43, 13333);
        System.out.println(sup1.get());

        //使用方法引用
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());

    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        //使用Lambda表达式
        Function<Integer, Employee> func1 = id -> new Employee(id);
        Employee employee = func1.apply(1001);
        System.out.println(employee);
        System.out.println("====================");

        //使用方法引用
        //读入Integer, 返回Employee, 自动匹配到public Employee(int id)
        Function<Integer, Employee> func2 = Employee::new;
        Employee employee1 = func2.apply(1002);
        System.out.println(employee1);

    }

    //BiFunction中的R apply(T t,U u) (二元)
    @Test
    public void test3() {
        //使用Lambda表达式
        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(1001, "Tom"));
        System.out.println("====================");

        //使用方法引用
        BiFunction<Integer, String, Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002, "Jerry"));
    }

    //数组引用
//Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("====================");

        //使用方法引用
        Function<Integer,String[]>func2 = String[]::new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
