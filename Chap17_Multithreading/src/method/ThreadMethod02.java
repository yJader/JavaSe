package method;

/**
 * @Author yJade
 * @Date 2022-07-17 20:52
 * @Package com.hsp.method
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.setDaemon(true);
        t2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "seconds past");
            Thread.sleep(1000);
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); //休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "正在运行中");
        }
    }
}