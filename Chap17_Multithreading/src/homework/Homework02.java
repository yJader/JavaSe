package homework;

import java.util.Scanner;

/**
 * @Author yJade
 * @Date 2022-07-21 22:01
 * @Package com.hsp.homework
 */
public class Homework02 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread t1 = new Thread(card);
        Thread t2 = new Thread(card);
        t1.setName("窗口A");
        t2.setName("窗口B");
        t1.start();
        t2.start();
    }
}

class Card implements Runnable {
    static int balance = 100000;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
//                试试别的操作(但是好像这样看不出同步)
//                System.out.println(Thread.currentThread().getName() + "为您服务, 当前余额为"
//                        + balance + ", 请输入取款额");
//                int money = scanner.nextInt();
//                if(money < 0) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                if (balance == 0) {
//                    System.out.println("余额不足");
//                    break;
//                } else if (balance >= money) {
//                    balance -= money;
//                    System.out.println(Thread.currentThread().getName() + "为您服务, 取款: " + money +", 当前余额: "
//                            + balance);
//                } else {
//                    System.out.println("取款过多哦, 请重新输入");
//                }

//              作业
                if (balance <= 0) break;
                balance -= 1000;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "为您服务, 取款1000, 当前余额为" + balance);
            }
        }
    }
}