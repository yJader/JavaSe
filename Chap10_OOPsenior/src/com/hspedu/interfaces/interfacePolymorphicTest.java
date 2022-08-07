package com.hspedu.interfaces;

public class interfacePolymorphicTest {
    public static void main(String[] args) {
        Action action = new Person();
        action.read();
        System.out.println(action.age);
        Person person =  (Person)action;
        person.test();
    }

}

interface Action {
    int age = 18;
    void say();
    void run();
    void read();
}

class Person implements Action {

    @Override
    public void say() {
        System.out.println("你好");
    }

    @Override
    public void run() {
        System.out.println("不要停下来.jpg");
    }

    @Override
    public void read() {
        System.out.println("好读书,读好书,读书好");
    }
    public void test () {
        System.out.println("TEST!");
    }
}