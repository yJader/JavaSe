package collection_;

import java.util.List;
import java.util.LinkedList;

public class ListExercise02 {
    public static void main(String[] args) {
        //List list = new ArrayList();
        List<Book> list = new LinkedList<>();
        //List list = new Vector();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
        list.add(new Book("西游记", "吴承恩", 10));

        sort(list);
        System.out.println(list);
    }

    public static void sort (List<Book> list) {
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = list.get(j);
                Book book2 = list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    //交换
                    list.set(j, book2);
                    list.set(j+1, book1);
                    flag = true;
                }
            }
            if (!flag) return;      //一次循环都没有交换,证明已经有序
        }
    }
}


