package Exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

public class HomeWork02 {
    public static void main(String[] args) {
        ArrayList<Car> list = new ArrayList<>();
        Car car1 = new Car("宝马",400000);
        Car car2 = new Car("宾利",5000000);
        Car car3 = new Car("奔驰", 8000000);
        //System.out.println(car1.equals(new Car("宝马",400000)));
        Car car1_ = new Car("宝马",400000);
        System.out.println("hahCode " + (car1.hashCode() == car1.hashCode()));
        list.add(car1);
        list.add(car2);
        list.add(car3);

        list.remove(car1);
        System.out.println(list);
        System.out.println(list.size());

//        list.clear();
//        System.out.println("Is the list clear?" + list.isEmpty());

        ArrayList list1 = new ArrayList();
        list1.addAll(list);
        list1.remove(car1);
        System.out.println("list.containsAll(list1)" + list.containsAll(list1));

        list1.removeAll(list);
        System.out.println("list1 = " + list1);

        System.out.println("用for遍历list");
        for (Car c:
             list) {
            System.out.println(c);
        }
        System.out.println("用Iterator遍历list");
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object next =  iter.next();
            System.out.println(next);
        }
    }
}

class Car{
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
