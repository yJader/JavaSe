package com.hspedu.innerClass;

public class AnonymousTest {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01("monkey");
        outer01.f1();
        System.out.println("--------------------------");
        outer01.f2();
    }
}

class Outer01 {
    String name;
    void f1() {
        IA test1 = new IA() {
            //基于接口的匿名内部类
            @Override
            public void cry() {
                System.out.println(name + " cry...");
            }
            public String temp = "能够使用接口之外的参数";
        };
        test1.cry();
        System.out.println(test1.getClass());
        //System.out.println(test1.temp);   ERROR
    }

    public void f2() {
        CA test2 = new CA("基于类的匿名内部类") {
            @Override
            public void hello() {
                super.hello();
                System.out.println("成功重写");
            }
        };
        test2.hello();
        System.out.println(test2.getClass());
    }

    public Outer01(String name) {
        this.name = name;
    }
}

interface IA {
    void cry();
}

class CA {
    private String name;
    public void hello() {
        System.out.println("Hello " + name);
    }

    public CA(String name) {
        this.name = name;
    }
}