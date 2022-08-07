package collection_;

import java.util.ArrayList;

/**
 * @Author yJade
 * @Date 2022-07-25 23:30
 * @Package collection_
 */
public class MyTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i--);
            ++count;
        }
        System.out.println(count);
    }
}
