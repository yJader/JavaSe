package collection_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("index = "+ i);
        }
        System.out.println(list);
        list.add(1, "韩顺平教育");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6, "三国演义");
        System.out.println(list);
    }
}
