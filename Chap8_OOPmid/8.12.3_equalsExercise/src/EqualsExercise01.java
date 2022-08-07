public class EqualsExercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("小明", 18, '男');
        Person person2 = new Person("小明", 18, '男');

        System.out.println("这是使用'==',本质对引用的比较:" + (person1 == person1));
        System.out.println("这是重载equals函数,对对象内容的比较:" + person1.equals(person2));

    }
}

class Person{
    private String name;
    private int age;
    private char gender;

    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Person) {
//            Object p = obj;       //error, 需要向下转型才能访问Person的成员变量
            Person p = (Person) obj;
            return name.equals(p.name) && age == p.age && gender == p.gender;
        }
        return false;
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
