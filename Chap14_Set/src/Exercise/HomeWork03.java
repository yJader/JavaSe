package Exercise;

import java.util.HashMap;
import java.util.Set;

public class HomeWork03 {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();

        map.put("jom", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);
        map.put("jack", 2600);

        Set keySet = map.keySet();
        for (Object key:
             keySet) {
            map.put(key, (int)map.get(key) + 100);
        }
        System.out.println(map);
    }
}

