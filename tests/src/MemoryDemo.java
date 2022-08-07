import java.util.ArrayList;

/**
 * @Author yJade
 * @Date 2022-07-31 23:32
 * @Package PACKAGE_NAME
 */
public class MemoryDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long before = runtime.freeMemory();
        System.out.println("before:" + before);

//        ArrayList<Object> arrayList = new ArrayList<>(10000000);
        int[] ints = new int[100000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
            if (i % 1000 == 0) System.out.println(i + " : " + (before - runtime.freeMemory()));
        }

        long after = runtime.freeMemory();
        System.out.println("after:" + after);
        System.out.println(before - after);
    }
}
