package Exercise;

import java.util.HashSet;
import java.util.Objects;

public class HomeWork06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);//ok
        set.add(p2);//okp1.name = "CC";set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC")); System.out.println(set);
        set.add(new Person(1001,"AA")); System.out.println(set);

    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
