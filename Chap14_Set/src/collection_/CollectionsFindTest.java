package collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsFindTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collections.replaceAll(list, "tom", "orz");
        System.out.println(list);
    }
}
