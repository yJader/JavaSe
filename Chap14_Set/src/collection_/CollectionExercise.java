package collection_;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionExercise {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<People>();
        arrayList.add(new People("小明", 18));
        arrayList.add(new People("小红", 17));
        arrayList.add(new People("小刚", 20));

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("-------------------");
        for (Object people : arrayList) {
            System.out.println(people);
        }
    }
}

class People{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + name
                + ", age = " + age;
    }
}