package syn;

/**
 * @Author yJade
 * @Date 2022-07-17 15:16
 * @Package com.hsp.threadUse
 * 使用多线程, 模拟三个窗口同时售票100张
 */
public class SellTicket_block {
    public static void main(String[] args) {

        SellTicket03_block sellTicket03 = new SellTicket03_block();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口
    }
}

//Runnable, 使用synchronized实现同步
class SellTicket03_block implements Runnable{
    private static int ticketNum = 100; //让多个线程共享 ticketNum
    private static int num = 0;
    static boolean loop = true;
    Object object = new Object(); //测试用对象

    //改为在代码块上锁
    public /*synchronized*/ void sell() { //同步方法, 在同一时刻, 只能有一个线程来执行run方法
        synchronized (/*this*/ object){
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }
//          test code
//        if(Thread.currentThread().getName().equals("Thread-0")) {
//            System.out.println("线程0, 使其休眠");
//            Thread.sleep(2000);
//            return;
//        }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票, 目前剩余 "
                    + (--ticketNum) + "张");
            num++;
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell(); //sell是一个同步方法
        }
        System.out.println("共售出" + num);
    }
}
