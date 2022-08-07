package map_;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        treeMap.put("1111", "a");
        treeMap.put("0", "aaaa");
        treeMap.put("1029039", '1');

        System.out.println("treeMap = " + treeMap);
    }
}
