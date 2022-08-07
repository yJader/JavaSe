package set_;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashSet01 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        System.out.println(set.add("3-"));
        System.out.println(set.add("1-"));
        System.out.println(set.add("2-"));
        System.out.println(set.add("4-"));
        System.out.println(set.add("1-"));

        System.out.println("set=" + set);
    }
}
