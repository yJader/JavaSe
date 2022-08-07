package method;

/**
 * @Author yJade
 * @Date 2022-07-17 18:29
 * @Package com.hsp.method
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T1 t = new T1();
        Thread t1 = new Thread(t);

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            Thread.sleep(50);
            if (i == 5) {
                t1.start();
                t1.join();
            }
        }
        System.out.println("主线程结束");
    }
}
class T1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程结束");
    }
}