package Lambda_;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author yJade
 * @Date 2022-08-05 18:54
 * @Package Lambda_
 */
public class FunctionalInterfaceTest {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("通过正常的函数, 购买了一件商品, 价格为: " + aDouble);
            }
        });

        System.out.println("---------------");

        happyTime(200, money -> System.out.println("通过Lambda写法的函数, 购买一件商品, 价格为: " + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");

        ArrayList<String> filterList = filterString(list, str -> str.contains("京"));

        System.out.println(list);
        System.out.println(filterList);
    }

    //这个函数的作用: 通过传入的Predicate进行判断, 过滤集合中的字符串
    public ArrayList<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();

        for (String f: list) {
            if (pre.test(f)) {
                filterList.add(f);
            }
        }

        return filterList;
    }
}
