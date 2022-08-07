package com.hsp.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author yJade
 * @Date 2022-07-14 16:21
 * @Package com.hsp.event_
 *  通过控制小球移动来学习Java的事件控制
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1600, 900);
        //添加KeyListener监听器
        //窗口JFrame对象可以监听键盘事件, 及可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//面板, 画出小球
//KeyListener 监听器, 用于监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    //为了让小球能够移动, 将坐标值设置为变量
    int x = 100;
    int y = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //当字符输出时, 触发该方法
    @Override
    public void keyTyped(KeyEvent e) {}

    //当某个键按下时, 触发该方法
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下");
        //根据键盘输入, 处理小球的移动
        //在java中, 会为每一个键分配一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) y++;
        if (e.getKeyCode() == KeyEvent.VK_UP) y--;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) x--;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) x++;
        //重绘, 会调用paint
        this.repaint();
    }

    //当某个键松开时, 触发该方法
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "已松开");
    }
}