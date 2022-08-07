package com.hspedu.innerClass;

public class InnerClassExercise {
    public static void main(String[] args) {
        Cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床啦");
            }
        });

        Cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课啦");
            }
        });
    }
}

interface Bell{
    void ring();
}

class Cellphone {
    static void alarmClock(Bell bell) {
        bell.ring();
    }
}