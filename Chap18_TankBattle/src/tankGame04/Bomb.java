package tankGame04;

/**
 * @Author yJade
 * @Date 2022-07-23 21:24
 * @Package tankGame04
 * 用于绘制坦克爆炸
 */
public class Bomb {
    int x, y;
    static final int MAX_LIFE = 30;
    int life = MAX_LIFE; //炸弹生命周期
    boolean isLive = true; // 是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少炸弹生命
    public void lifeDown() {
        if (life > 0) life--;
        else isLive = false;
    }
}
