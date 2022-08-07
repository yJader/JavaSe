package syn;

/**
 * @Author yJade
 * @Date 2022-07-17 15:16
 * @Package com.hsp.threadUse
 * 使用多线程, 模拟三个窗口同时售票100张
 * synchronized
 */
public class SellTicket {
    public static void main(String[] args) {

        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口
    }
}

//Runnable, 使用synchronized实现同步
class SellTicket03 implements Runnable{
    private static int ticketNum = 100; //让多个线程共享 ticketNum
    private static int num = 0; //计数,验证是否售出正确的票数
    static boolean loop = true;

    //1. public synchronized void sell() {} 是一个同步方法
    //2. 此时锁锁在 this对象上
    //3. 也可以改为在代码块上加锁, 同步代码块
    public synchronized void sell() { //同步方法, 在同一时刻, 只能有一个线程来执行run方法
        if (ticketNum <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }
//        test code
//        if(Thread.currentThread().getName().equals("Thread-0")) {
//            System.out.println("线程0, 使其休眠");
//            Thread.sleep(2000);
//            return;
//        }

        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票, 目前剩余 "
                + (--ticketNum) + "张");
        num++;
    }

    @Override
    public void run() {
        while (loop) {
            sell(); //sell是一个同步方法
        }
        System.out.println("共售出" + num);
    }
}
