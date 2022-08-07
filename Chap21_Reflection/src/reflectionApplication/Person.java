package reflectionApplication;

/**
 * @Author yJade
 * @Date 2022-08-03 15:47
 * @Package reflectionApplication
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements MyInterface, Comparable<String>{

    private String name;
    int age = -1;
    public int id = -1;

    public Person() {}

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String showNation(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String displayInterest(String interest, int age) throws NullPointerException, ClassCastException {
        return interest + age;
    }

    @Override
    public void info() {
        System.out.println("我不是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static  void showDesc() {
        System.out.println("我是一个可爱的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
