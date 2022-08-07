package com.hsp.draw;

import javax.swing.*;
import java.awt.*;


public class DrawCircle extends JFrame { //JFrame对应程序窗口, 可以理解为一个画框
    //定义一个面板mp
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出绘画程序");
    }

    public DrawCircle() { //构造器
        //初始化面板
        mp = new MyPanel();
        //将面板放入窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(1080, 920);
        //当关闭窗口时, 退出程序(如果没有,关闭窗口后程序并不会结束)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //可以显示
        System.out.println("调用paint方法了吗");
    }
}

//定义一个MyPanel, 继承JPanel类, 画图形, 在Panel面板上画
class MyPanel extends JPanel {
    //MyPanel对象就是一个画板
    //Graphics g: g是一只画笔, Graphics提供了很多绘画的方法
    Graphics g;
    static int count = 0;

    @Override
    public void paint(Graphics g) { //绘图方法
        super.paint(g);//调用父类的方法完成初始化
        //System.out.println("g.getClass() = " + g.getClass());
        System.out.println("paint方法被调用了" + ++count + "次");

        g.drawOval(10, 10, 100, 100);
    }
}