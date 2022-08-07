public class Generic01 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass<>(100, "200", 10);
        TestClass<Integer> testClass1 = (TestClass<Integer>) testClass;
        System.out.println(testClass);
        System.out.println(testClass1);
    }
}

class TestClass <E> {
    E a;
    E b;

    Integer c;

    public TestClass(E a, E b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}' + showClass();
    }

    public String showClass() {
        return  "showClass: \n{" +
                "a.getClass() = " + a.getClass() +
                ", b.getClass() = " + b.getClass() +
                ", c.getClass() = " + c.getClass() +
                '}';
    }
}
