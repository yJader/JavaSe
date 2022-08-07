package thread_jdk5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yJade
 * @Date 2022-07-24 16:26
 * @Package thread_jdk5
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service; //service的类型其实是ThreadPoolExecutor

        //设置线程池的属性
//        ((ThreadPoolExecutor) service).setCorePoolSize(15);
//        ((ThreadPoolExecutor) service).setKeepAliveTime();


        service.execute(new NumThread()); //适合使用于Runnable
        service.execute(new NumThread1());
       // service.submit(Callable callable); //适合使用于Callable

        service.shutdown();
    }
}

class NumThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) == 1) {
                System.out.println(Thread.currentThread().getName() + "数到了" + i);
            }
        }
    }
}

class NumThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) != 1) {
                System.out.println(Thread.currentThread().getName() + "数到了" + i);
            }
        }
    }
}
