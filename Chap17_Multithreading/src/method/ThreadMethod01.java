package method;

/**
 * @Author yJade
 * @Date 2022-07-17 17:31
 * @Package com.hsp.method
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("joker");
        t.setPriority(Thread.MIN_PRIORITY);
        //System.out.println(t.getName());
        t.start();

        //主线程打印5次"Hi", 然后中断子线程休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Hi" + i);
        }
        t.interrupt(); // 当执行到这里时, 会中断t线程的休眠
    }
}

class T extends Thread{
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+ " 吃包子" + i);
            }
            try{
                System.out.println(Thread.currentThread().getName() + " 休眠中");
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                //当该线程执行到一个Interrupt方法时, 就会catch一个异常, 在这里写自己的业务逻辑
                //InterruptedException : 捕获一个中断异常
                System.out.println(Thread.currentThread().getName() + " 被Interrupt了");
            }
        }
    }
}
