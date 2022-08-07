package com.hsp.tankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Author yJade
 * @Date 2022-07-14 14:53
 * @Package com.hsp.tankGame
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克, 并放入Vector中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        hero = new Hero(100, 100, 0, 5);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(100 * (i+1), 50, 2));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1600, 900); //地图底色

        //创建坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //画敌人
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
    }

    /**
     * 编写方法, 画出坦克
     * @param x 坦克中心横坐标
     * @param y 坦克中心纵坐标
     * @param g 画笔
     * @param direct 坦克方向
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //设置坦克颜色
        switch (type) {
            case 0: //Hero
                g.setColor(new Color(0x66ccff));
                break;
            case 1: //Enemy
                g.setColor(new Color(0xEE0000));
                break;
        }
        // 根据坦克方向, 绘制坦克
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x-20, y-30, 10, 60, false);//坦克左轮
                g.fill3DRect(x+10, y-30, 10, 60, false); //坦克右轮
                g.fill3DRect(x-10, y-20, 20, 40, false); //坦克主体
                g.fillOval(x-10, y-10, 20, 20); //坦克圆盖
                g.drawLine(x, y, x, y-35); //炮管
                break;
            case 1: //向右
                g.fill3DRect(x-30, y-20, 60, 10, false);//坦克左轮
                g.fill3DRect(x-30, y+10, 60, 10, false); //坦克右轮
                g.fill3DRect(x-20, y-10, 40, 20, false); //坦克主体
                g.fillOval(x-10, y-10, 20, 20); //坦克圆盖
                g.drawLine(x, y, x+35, y); //炮管
                break;
            case 2: //向下
                g.fill3DRect(x-20, y-30, 10, 60, false);//坦克左轮
                g.fill3DRect(x+10, y-30, 10, 60, false); //坦克右轮
                g.fill3DRect(x-10, y-20, 20, 40, false); //坦克主体
                g.fillOval(x-10, y-10, 20, 20); //坦克圆盖
                g.drawLine(x, y, x, y+35); //炮管
                break;
            case 3: //向左
                g.fill3DRect(x-30, y-20, 60, 10, false);//坦克左轮
                g.fill3DRect(x-30, y+10, 60, 10, false); //坦克右轮
                g.fill3DRect(x-20, y-10, 40, 20, false); //坦克主体
                g.fillOval(x-10, y-10, 20, 20); //坦克圆盖
                g.drawLine(x, y, x-35, y); //炮管
                break;
            default:
                System.out.println("direct输入错误");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            hero.moveRight();
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            hero.moveDown();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            hero.moveLeft();
        }
        //System.out.println(hero);
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
