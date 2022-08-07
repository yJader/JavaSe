package com.hsp.tankGame;

/**
 * @Author yJade
 * @Date 2022-07-14 14:45
 * @Package com.hsp.tankGame
 */
public class Hero extends Tank{
    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
}
