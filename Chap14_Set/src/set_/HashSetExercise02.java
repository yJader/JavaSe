package set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class HashSetExercise02 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        //linkedHashSet.add();
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

class Employee{
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, int year, int month, int day) {
        this.name = name;
        this.sal = sal;
        this.birthday = new MyDate(year, month, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return sal == employee.sal && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday);
    }
}
