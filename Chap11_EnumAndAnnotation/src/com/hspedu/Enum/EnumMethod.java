package com.hspedu.Enum;

public class EnumMethod {
    public static void main(String[] args) {
        Season spring = Season.SPRING;

        //输出枚举对象的名字
        System.out.println(spring.name());
        //ordinal()输出次序
        System.out.println(spring.ordinal());

        //values返回所有枚举对象
        Season[] seasons = Season.values();
        for(Season season: seasons) {
            System.out.println(season);
        }

        Season summer = Season.valueOf("SUMMER");
        System.out.println("summer=" + summer);
        System.out.println(summer == Season.SUMMER);

        System.out.println(summer.compareTo(spring));
        System.out.println(spring.compareTo(summer));
    }
}

enum Season{
    SPRING("春", "温暖"), SUMMER("夏", "炎热"),
    AUTUMN("秋", "凉爽"), WINTER("冬", "寒冷");

    private String name;
    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}