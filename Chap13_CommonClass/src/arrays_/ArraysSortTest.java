package arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortTest {
    public static void main(String[] args) {
        Integer[] integers = {4, 5, 1, 2, 3};

        System.out.println(integers);
        System.out.println(Arrays.toString(integers));

        Integer[] integers1 = integers;
        Arrays.sort(integers1);
        System.out.println(Arrays.toString(integers1));

        Integer[] integers2 = integers;
        Arrays.sort(integers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(integers2));

        Integer[] integers3 = integers;
        Arrays.sort(integers3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.compareTo(o2);
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(integers3));

    }
}
