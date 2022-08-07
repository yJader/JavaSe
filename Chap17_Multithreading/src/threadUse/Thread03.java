package threadUse;

/**
 * @Author yJade
 * @Date 2022-07-17 15:02
 * @Package com.hsp.threadUse
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        //Thread thread2 = new Thread(new T2());


        thread1.start();
        thread2.start();
        //主线程结束得很快
    }
}

class T1 implements Runnable{
    static int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World " + (++times) + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 10) break;
        }
    }
}

class T2 implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hi " + (++times) + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 5) break;
        }
    }
}