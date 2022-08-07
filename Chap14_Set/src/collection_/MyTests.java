package collection_;

import java.util.Vector;

/**
 * @Author yJade
 * @Date 2022-07-23 10:02
 * @Package collection_
 */
public class MyTests {
    public static void main(String[] args) {
        //存储基础数据类型
        Vector<Integer> integers = new Vector<>();
        Integer integer = 1000;
        integers.add(integer);
        System.out.println(integers);
        integer = 500;
        System.out.println(integers);


        System.out.println("存储引用数据类型, 存储的是引用(地址)");
        Vector<T> ts = new Vector<>();
        T t = new T();
        ts.add(t);
        System.out.println(ts);
        t.setI(100);
        t.setStr("World");
        System.out.println(ts);
    }
}

class T {
    int i = 0;
    String str = "Hello";

    @Override
    public String toString() {
        return "T{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setStr(String str) {
        this.str = str;
    }
}