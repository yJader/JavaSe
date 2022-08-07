package reflectionApplication;

import java.io.Serializable;

/**
 * @Author yJade
 * @Date 2022-08-03 15:48
 * @Package reflectionApplication
 */

/**
 * @param <T> 泛型T仅为测试用
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
