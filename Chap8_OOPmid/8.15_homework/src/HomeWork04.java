public class HomeWork04 {
}

abstract class Employee{
    protected String name;
    protected double salary;
    protected int days;

    public Employee(String name, double salary, int days) {
        this.name = name;
        this.salary = salary;
        this.days = days;
    }

    abstract public void printSalary();
}

class Manager extends Employee{
    private double bonus;
    public Manager(String name, double salary, int days, double bonus) {
        super(name, salary, days);
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("name:" + name + " grade:Manger" +
                " salary:" + (bonus + salary * days * 1.2));
    }
}

class Worker extends Employee{
    public Worker(String name, double salary, int days) {
        super(name, salary, days);
    }

    @Override
    public void printSalary() {
        System.out.println("name:" + name + " grade:Manger" +
                " salary:" + (salary * days * 1));
    }
}