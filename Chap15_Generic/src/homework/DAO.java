package homework;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();

        for (String s:
             keySet) {
            list.add(map.get(s));
        }

        return list;
    }

    public List<T> listError() {
        System.out.println(map.values().getClass());
        List<T> list = (List<T>)map.values();
        return list;
    }

    public void delete(String id) {
        if(map.containsKey(id)) map.remove(id);
        else System.out.println("id输入错误");
    }
}
