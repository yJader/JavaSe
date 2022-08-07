package communication;

/**
 * @Author yJade
 * @Date 2022-07-24 13:19
 * @Package communication
 */
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer1 = new Producer(clerk);
        producer1.setName("生产者1");
        Consumer consumer1 = new Consumer(clerk);
        consumer1.setName("消费者1");

        producer1.start();
        consumer1.start();
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产...");

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费...");

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumeProduct();
        }
    }
}

class Clerk{
    private int productCount = 0;
    final int MAX_COUNT = 10;
    //生产产品
    public synchronized void produceProduct() { //同步监视器是Clerk对象
        if (productCount < MAX_COUNT) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + " 生产第" + productCount + "个产品");

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    //消费产品
    public synchronized void consumeProduct() { //同步监视器是Clerk对象
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + " 消费第" + productCount + "个产品");
            productCount--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}