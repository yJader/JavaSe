package thread_jdk5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author yJade
 * @Date 2022-07-24 14:59
 * @Package thread_jdk5
 * 创建线程的方式三 实现Callable接口 (JDK5.0新增)
 */
public class CallableTest {
    public static void main(String[] args) {
        T t = new T();
        FutureTask futureTask = new FutureTask(t);

        new Thread(futureTask).start();

        try {
            //get()的返回值为FutureTask构造器参数Callable实现类重写的call() 的返回值(default为Object)
            Object sum = futureTask.get();
            System.out.println("总和为: " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class T implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i & 1) == 1) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}