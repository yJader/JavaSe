import java.util.ArrayList;
import java.util.List;

public class GenericExtend {
    public static void main(String[] args) {
        Object o = new String("Hello World");
        //List<Object> list = new ArrayList<String>();
        //Error : 不兼容的类型。实际为 java.util.ArrayList<java.lang.String>'，需要 'java.util.List<java.lang.Object>'

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();
        //举例说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();
        //如果是List<?> c ，可以接受任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);
        //List<? extends AA> c： 表示上限，可以接受AA 或者AA 子类
        // printCollection2(list1);//×
        // printCollection2(list2);//×
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√
        //List<? super AA> c: 支持AA 类以及AA 类的父类，不限于直接父类
        printCollection3(list1);//√
        //printCollection3(list2);//×
        printCollection3(list3);//√
        //printCollection3(list4);//×
        //printCollection3(list5);//×
    }
    //说明: List<?> 表示任意的泛型类型都可以接受
        public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }


    // ? super 子类类名AA:支持AA 类以及AA 类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }
}

class AA {
}
class BB extends AA {
}
class CC extends BB {
}