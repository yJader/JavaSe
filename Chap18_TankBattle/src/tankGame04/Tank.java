package tankGame04;

/**
 * @Author yJade
 * @Date 2022-07-14 14:42
 * @Package com.hsp.tankGame
 */
public class Tank {
    private int x; //坦克中心横坐标
    private int y; //坦克中心纵坐标
    private int direct = 0; //坦克炮口朝向
    private int speed = 5; //坦克移动速度
    boolean isLive = true;

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (y - 30 > 0){
            y -= speed;
        }
    }
    public void moveDown() {
        if (y + 30 < TankGame04.HEIGHT){
            y += speed;
        }
    }
    public void moveRight() {
        if (x + 30 < TankGame04.WIDTH) {
            x += speed;
        }
    }
    public void moveLeft() {
        if (x - 30 > 0){
            x -= speed;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", direct=" + direct +
                ", speed=" + speed +
                '}';
    }
}
