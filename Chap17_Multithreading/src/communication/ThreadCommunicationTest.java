package communication;

/**
 * @Author yJade
 * @Date 2022-07-24 10:50
 * @Package communication
 * 使用2个线程打印1-100, 其中线程1,2交替打印
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Thread thread1 = new Thread(printNumber);
        Thread thread2 = new Thread(printNumber);
        thread1.start();
        thread2.start();
    }
}

class PrintNumber implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num <= 100) {

                    notify(); //唤醒另一个线程, 但是由于锁在当前线程手上, 锁未释放, 另一个线程无法运行
                    //(this.notify())

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " print: " + num++);

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    notifyAll(); //线程退出时要记得notify另一个线程
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getState());
    }
}