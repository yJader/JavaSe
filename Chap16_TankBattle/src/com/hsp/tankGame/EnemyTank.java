package com.hsp.tankGame;

/**
 * @Author yJade
 * @Date 2022-07-14 22:36
 * @Package com.hsp.tankGame
 */
public class EnemyTank extends Tank{
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }


}
