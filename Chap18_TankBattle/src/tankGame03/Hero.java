package tankGame03;

/**
 * @Author yJade
 * @Date 2022-07-14 14:45
 * @Package com.hsp.tankGame
 */
public class Hero extends Tank {
    //定义一个Shot对象, 表示一次射击(线程)
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }

    public void shotEnemy() {
        // 创建 Shot 对象, 根据当前Hero对象的位置和方向创建Shot
        switch (getDirect()) {
            case 0: //上
                shot = new Shot(getX(), getY()-35, getDirect());
                break;
            case 1: //右
                shot = new Shot(getX()+35, getY(), getDirect());
                break;
            case 2: //下
                shot = new Shot(getX(), getY()+35, getDirect());
                break;
            case 3: //左
                shot = new Shot(getX()-35, getY(), getDirect());
                break;
        }
        new Thread(shot).start();
    }
}
