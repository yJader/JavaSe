package objectStream;

import java.io.Serializable;

/**
 * @Author yJade
 * @Date 2022-07-29 23:02
 * @Package objectStream
 *
 * Person类需要满足如下的要求, 方可序列化
 * 1. 需要实现接口 Serializable
 * 2. 当前类提供一个全局常量
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 123456789L;

    private String name;
    private int age;
    private Boolean isMale;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }

    public Person(String name, int age, Boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
}
