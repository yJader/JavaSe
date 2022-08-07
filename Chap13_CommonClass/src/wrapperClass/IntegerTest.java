package wrapperClass;

public class IntegerTest {
    public static void main(String[] args) {
        int n = 10;
        Integer integer1 = n, integer2 = n;
        System.out.println(integer1 == integer2);
        System.out.println(integer1.hashCode());
        System.out.println(integer2.hashCode());
    }
}
