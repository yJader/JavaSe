package collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        //add: 添加单个元素
        list.add("test"); list.add(250); list.add(true);
        System.out.println("list = " + list);

        //remove: 删除指定元素
        list.remove(true);      //删除指定元素
        list.remove(0);     //删除第一个元素

        //contains: 查找指定元素是否存在
        System.out.println(list.contains(250));

        //size: 获取元素个数
        System.out.println(list.size());

        //isEmpty
        System.out.println(list.isEmpty());

        //clear: 清空
        list.clear();
        System.out.println("list = " + list);

        //addAll: 添加多个元素
        ArrayList list2 = new ArrayList(); list2.add("abandon"); list2.add("delight");
        list.addAll(list2);
        System.out.println("list = " + list);

        //containsAll: 查找多个元素是否都存在
        System.out.println(list.containsAll(list2));

        //removeAll: 删除多个元素
        list.add("digital");
        list.removeAll(list2);
        System.out.println("list = " + list);
    }
}
