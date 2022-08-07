package homework;

import java.util.Scanner;

/**
 * @Author yJade
 * @Date 2022-07-21 18:50
 * @Package com.hsp.homework
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        B b = new B(a);
        Thread thread = new Thread(b);
        thread.start();
    }
}

class A extends Thread { //打印随机数的线程
    private Boolean state = true;

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (state) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程打印随机数: " + (int)(Math.random() * 100));
        }
    }
}

class B implements Runnable{
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            //接受到用户的输入
            System.out.println("输入Q退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                a.setState(false);
                System.out.println("已退出");
                break;
            }
        }
    }
}