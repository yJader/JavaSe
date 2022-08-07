import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HomeWork01 {
    public static void main(String[] args) {
//        m1("Hello");
    }

    @Test
    void m1(String message) {
        System.out.println("m1 return : " + message);
    }
    @Test
    static void m2(String message) {
        System.out.println("m2 return : " + message);
    }
    @Test
    static void m3() {
        System.out.println("m3 return : no message");
    }
}

class DAO<T> {

}
