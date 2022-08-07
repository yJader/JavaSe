import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GenericUse {
    public static void main(String[] args) {
        Employee employee1 = new Employee("joker", 10000, 2000, 1, 1);
        Employee employee2 = new Employee("panther", 12000, 1991, 1, 2);
        Employee employee3 = new Employee("skull", 9999, 1999, 12,31);
        Employee employee4 = new Employee("joker", 10000, 1000, 1, 1);
        Employee employee5 = new Employee("joker", 0, 2000, 1, 1);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee4);
        employees.add(employee3);
        employees.add(employee5);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(!o1.getName().equals(o2.getName())) {
                    System.out.println("o1.getName().equals(o2.getName()) = " + true);
                    return o1.getName().compareTo(o2.getName());
                }
                else if(o1.getBirthday().compareTo(o2.getBirthday()) != 0)
                    return o1.getBirthday().compareTo(o2.getBirthday());
                else return o1.getSal() - o2.getSal();
            }
        });

        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private int sal;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                "}\n";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int sal, int year, int month, int day) {
        this.name = name;
        this.sal = sal;
        this.birthday = new MyDate(year, month, day);
    }
}

class MyDate implements Comparable{
    private int year, month, day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(Object o) {
        MyDate other = (MyDate) o;
        if(year != other.getYear()) return year - other.year;
        else if(month != other.getMonth()) return month - other.month;
        else return day - other.day;
    }
}