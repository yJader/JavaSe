package syn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yJade
 * @Date 2022-07-21 16:47
 * @Package com.hsp.syn
 * 解决线程安全的方式三 Lock
 */

public class LockTest {
    public static void main(String[] args) {
        SellTicket_Lock sellTicket = new SellTicket_Lock();

        Thread t1 = new Thread(sellTicket);
        Thread t2 = new Thread(sellTicket);
        Thread t3 = new Thread(sellTicket);

        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t3.setName("售票窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SellTicket_Lock implements Runnable{
    private static int ticketNum = 100; //让多个线程共享 ticketNum
    static int num = 0;
    //1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2. 调用锁定方法lock()
                lock.lock();

                if (ticketNum <= 0) {
                    System.out.println("车票已售罄");
                    break;
                }

                //休眠50ms
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票, 目前剩余 "
                        + (--ticketNum) + "张");
                num++;
            } finally {
                //3. 调用解锁方法: unlock()
                lock.unlock();
            }
        }
        System.out.println("共售出 " + num);
    }
}