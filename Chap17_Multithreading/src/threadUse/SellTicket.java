package threadUse;

/**
 * @Author yJade
 * @Date 2022-07-17 15:16
 * @Package com.hsp.threadUse
 * 使用多线程, 模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {
//        System.out.println("Thread实现");
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //因为是先判断, 后--, 多个线程同时访问ticketNum时, 会出现超卖的现象
//        //共售出 177
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        //使用接口的方式实现售票
        System.out.println("Runnable实现");
        new Thread(new SellTicket02()).start();
        new Thread(new SellTicket02()).start();
        new Thread(new SellTicket02()).start();
    }
}

//使用Thread方式
class SellTicket01 extends Thread{
    private static int ticketNum = 100; //让多个线程共享 ticketNum
    //static int num = 0;

    @Override
    public void run() {
        while (true) {
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
            //num++;
        }
        //System.out.println("共售出 " + num);
    }
}

//说用Runnable
class SellTicket02 implements Runnable{
    private static int ticketNum = 100; //让多个线程共享 ticketNum
    //static int num = 0;

    @Override
    public void run() {
        while (true) {
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
            //num++;
        }
        //System.out.println("共售出 " + num);
    }
}