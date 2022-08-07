package tankGame03;

/**
 * @Author yJade
 * @Date 2022-07-21 23:11
 * @Package tankGame
 * 射击一个子弹
 */
public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 7;
    boolean isLive = true; //子弹是否存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { //射击(子弹移动)
        while (isLive) {
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向来改变x, y坐标
            switch (direct) {
                case 0: //上
                    y -= speed;
                    break;
                case 1: //右
                    x += speed;
                    break;
                case 2: //下
                    y += speed;
                    break;
                case 3: //左
                    x -= speed;
                    break;
            }
            //test code:
            System.out.println("子弹坐标(" + x + ", " + y + ')');
            //当子弹移动到面板边界时, 销毁子弹(结束线程)
            if (!(0 <= x && x <= TankGame03.WIDTH && 0 <= y && y <= TankGame03.HEIGHT)){
                isLive = false;
            }
        }
    }
}
