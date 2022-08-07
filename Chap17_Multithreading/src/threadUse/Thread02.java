package threadUse;

/**
 * @Author yJade
 * @Date 2022-07-16 22:58
 * @Package com.hsp.threadUse
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); //ERROR, dog无法调用start方法
        //需要创建一个Thread对象, 把dog对象(已经实现Runnable), 放入Thread
        Thread thread = new Thread(dog);
        thread.start();

         Tiger tiger = new Tiger();//实现了Runnable
         ThreadProxy threadProxy = new ThreadProxy(tiger);
         threadProxy.start();
    }
}

class Animal{

}

class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("嗷嗷 我是老虎" + Thread.currentThread().getName());
    }
}

//线程代理类, 模拟了一个极简的Thread类
class ThreadProxy implements Runnable{
    private Runnable target = null; //属性, 类型是 Runnable

    @Override
    public void run() {
        if (target != null){
            target.run(); //动态绑定, 运行类型是Tiger
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0(); //此时实现多线程方法
    }

    private void start0() {
        run();
    }
}

class Dog implements Runnable { //通过实现Runnable接口, 开发线程
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫 " + (++count) + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) break;
        }
    }
}