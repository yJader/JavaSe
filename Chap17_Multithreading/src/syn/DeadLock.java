package syn;

/**
 * @Author yJade
 * @Date 2022-07-20 21:05
 * @Package com.hsp.syn
 * 模拟线程死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A 线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B 线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object(); //为保证多线程, 使用static来实现共享同一个对象
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) { //构造器
        this.flag = flag;
    }

    @Override
    public void run() {

        //下面业务逻辑的分析
        //1. 若flag 为 True, 线程A就会得到/持有 o1 对象锁, 然后尝试 o2 对象锁
        //  如果线程A得不到o2对象锁, 就会变为Blocked
        //2. 如果flag 为 False, 线程B就会先得到/持有 o2 对象锁, 然后尝试 o1 对象锁
        //  如果线程B得不到o1对象锁, 就会变为Blocked
        if (flag) {
            synchronized (o1) { //对象互斥锁, 下面就是同步代码
                System.out.println(Thread.currentThread().getName() + " 进入 1");
                synchronized (o2) { //这里获得
                    System.out.println(Thread.currentThread().getName() + " 进入 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入 4");
                }
            }
        }
    }
}