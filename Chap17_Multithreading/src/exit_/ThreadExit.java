package exit_;

/**
 * @Author yJade
 * @Date 2022-07-17 16:24
 * @Package com.hsp.exit_
 */
public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        t.start();

        //如果希望main线程通知t1线程的终止, 必须可以修改loop
        //让t1 退出run方法, 从而停止t1线程 <通知方式>
        System.out.println("主线程休眠5s");
        for (int i=0; i<5; i++) {
            System.out.println(i + "second pasted...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        t.setLoop(false);
    }
}

class T extends Thread{
    private int count = 0;
    //控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 正在运行中 " + ++count);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}