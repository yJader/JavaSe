package tankGame04;

import java.util.Vector;

/**
 * @Author yJade
 * @Date 2022-07-14 22:36
 * @Package com.hsp.tankGame
 */
public class EnemyTank extends Tank implements Runnable  {
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    @Override
    public void run() {
        while (isLive) {
            int step = (int)(Math.random() * 20);
            //根据坦克方向向前移动
            switch (getDirect()) {
                case 0: //向上
                    for (int i=0; i<step; i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1: //向右
                    for (int i=0; i<step; i++) {
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2: //向下
                    for (int i=0; i<step; i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3: //向左
                    for (int i=0; i<step; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            //随机改变方向
            setDirect((int)(Math.random() * 4));
        }
    }
}
