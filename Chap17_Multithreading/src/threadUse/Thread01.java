package threadUse;

/**
 * @Author yJade
 * @Date 2022-07-15 20:03
 * @Package com.hsp.threadUse
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象, 可以当做线程使用
        Cat cat = new Cat();

        //源码
        /*
        (1)
            public synchronized void start() {
                start0();
            }
        (2)
        start0() 是本地方法，是JVM 调用, 底层是c/c++实现
        真正实现多线程的效果， 是start0(), 而不是run
            private native void start0();
        */
        cat.start(); //启动线程, 最终会执行cat的run方法

        //cat.run(); //run方法就是一个普通的方法, 没有真正地启动一个线程, 就会把run方法执行完毕, 再向下执行
        //说明: 当main线程启动一个子线程, Thread-0, 主线程不会阻塞, 会继续执行
        //这时 主线程和子线程交替进行
        System.out.println("主线程继续执行" + Thread.currentThread().getName()); //名字:main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}


/**
 * 1.当一个类继承了Thread类之后, 这个类就可以当做线程来使用
 * 2.我们会重写run方法, 写上自己的业务逻辑
 */
class Cat extends Thread {


    @Override
    public void run() { //重写run方法, 写上自己的业务逻辑
        int times = 0;
        while (true) {
            //该线程每隔1s, 在控制台输出"喵喵, 我是小猫咪"
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());

            //让该线程休眠1秒 ctrl+alt+t 快速添加环绕
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(times == 5) {
                break; //当times 到80, 退出while, 这时候线程也就退出
            }
        }

    }
}