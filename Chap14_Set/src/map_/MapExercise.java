package map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Map<Integer, Object> hashMap = new HashMap<>();

        hashMap.put(1, new Employee("小明", 10000));
        hashMap.put(2, new Employee("小刚", 11000));
        hashMap.put(3, new Employee("小红", 8000));
        hashMap.put(4, new Employee("小花", 30000));

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry m = (Map.Entry) next;
            System.out.println(m.getKey().toString() + "\t" +m.getValue().toString());
        }
    }
}

class Employee{
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}