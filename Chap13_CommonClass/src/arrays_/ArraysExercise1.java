package arrays_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysExercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        Book[] books = new Book[5];

//        for(int i=0; i<n; i++){
//            String name = scanner.next();
//            books[i].setName(name);
//            int price = scanner.nextInt();
//            books[i].setPrice(price);
//        }
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);
        books[4] = new Book("java 从入门到放弃~", 10);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getName().compareTo(o2.getName()) != 0) return o1.getName().compareTo(o2.getName());
                else return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "书名: " + name
                + "价格" + price;
    }
}
