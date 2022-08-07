package set_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add(new Employ("小明", 18));
        hashSet.add(new Employ("小明", 18));
        hashSet.add(new Employ("小明", 19));

        System.out.println(hashSet);
    }
}

class Employ{
    private String name;
    private int age;

    public Employ(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return age == employ.age && Objects.equals(name, employ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}