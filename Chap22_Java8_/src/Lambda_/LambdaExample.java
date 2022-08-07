package Lambda_;

import org.junit.jupiter.api.Test;

/**
 * @Author yJade
 * @Date 2022-08-04 22:48
 * @Package Lambda_
 */
public class LambdaExample {
    @Test
    public void test1(){
        //未使用Lambda表达式的写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lambda!");
            }
        };
        r1.run();

        System.out.println("========================");
        //Lambda表达式写法
        Runnable r2 = () -> System.out.println("hi Lambda!");
        r2.run();
    }
}
