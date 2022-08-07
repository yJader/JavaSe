/**
 * @Author yJade
 * @Date 2022-07-27 16:09
 * @Package PACKAGE_NAME
 */
public class Swap {
    public static void main(String[] args) {
        T t1 = new T(1);
        T t2 = new T(2);

        System.out.println(t1 + "\n" + t2);
        swap(t1, t2);
        System.out.println(t1 + "\n" + t2);
    }

    static void swap(T t1, T t2) {
        T t = t1;
        t1 = t2;
        t2 = t;
    }

    static class T {
        int i;

        @Override
        public String toString() {
            return "T{" +
                    "i=" + i +
                    '}';
        }

        public T(int i) {
            this.i = i;
        }
    }
}
