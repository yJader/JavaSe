package class_;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

/**
 * @Author yJade
 * @Date 2022-08-02 20:54
 * @Package class_
 */
public class ClassTest {
    @Test
    public void test(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] i1 = new int[10];
        int[] i2 = new int[100];
        Class<? extends int[]> c10 = i1.getClass();
        Class<? extends int[]> c11 = i2.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11); //true
    }
}
