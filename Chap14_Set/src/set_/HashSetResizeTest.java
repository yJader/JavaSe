package set_;

import java.util.HashSet;

public class HashSetResizeTest {
    public static void main(String[] args) {
        HashSet set = new HashSet<>();

//        for (int i = 0; i < 100; i++) {
//            set.add(i);
//        }
//        System.out.println(set);

        for (int i = 0; i < 100; i++) {
            set.add(new A(i));
        }
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}