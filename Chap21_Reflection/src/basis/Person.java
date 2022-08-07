package basis;

/**
 * @Author yJade
 * @Date 2022-08-01 11:54
 * @Package basis
 */
public class Person {
    private String name;
    public int age = -1;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

//    private Person() {
//        System.out.println("调用了private Person()方法");
//    }
    public Person() {
        System.out.println("调用了public Person()方法");
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}
