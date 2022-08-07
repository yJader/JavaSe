package com.hsp.tankGame;

import javax.swing.*;

/**
 * @Author yJade
 * @Date 2022-07-14 14:56
 * @Package com.hsp.tankGame
 */
public class TankGame01 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();

    }

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp); //将面板(游戏绘图区域加入)
        this.setSize(1600, 900); //窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
        this.setVisible(true);
    }
}
