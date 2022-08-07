import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        int length = 3;
        Person[] persons = new Person[length];
        Person temp;

        for (int i = 0; i < length; i++) {
            Scanner scanner = new Scanner(System.in);
            persons[i] = new Person();      //对象数组声明后需要对每个对象初始化
            persons[i].setName(scanner.next());
            persons[i].setAge(scanner.nextInt());
            persons[i].setJob(scanner.next());
        }

        for(int i=0; i<length-1; i++) {
            for(int j=0; j<length-1-i; j++) {
                if(persons[j].getAge() < persons[j+1].getAge()) {
                    temp = persons[j+1];
                    persons[j+1] = persons[j];
                    persons[j] = temp;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println(persons[i]);
        }
    }
}

class Person{
    private String name;

    private int age;
    private String job;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name:" + name + "age:" + age + "job:" + job;
    }
}