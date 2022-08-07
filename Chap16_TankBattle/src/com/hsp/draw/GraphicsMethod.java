package com.hsp.draw;

import javax.swing.*;
import java.awt.*;

public class GraphicsMethod extends JFrame {
    public static void main(String[] args) {
        new GraphicsMethod();
    }

    public GraphicsMethod() {
        MyPanel1 mp = new MyPanel1();
        this.add(mp);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel1 extends JPanel{
    Graphics g;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawLine(0,0,100,100);
        g.drawRect(100, 100, 200, 100);
        g.drawOval(100, 100, 200, 200);
        g.fillRect(100, 300, 200, 100);
        g.fillOval(150, 150, 100, 100);
        //设置画笔颜色
        g.setColor(Color.blue);
        for (int i = 100; i < 300; i+=20) {
            g.fillRect(i, 300, 10, 100);
        }

        //画字符串
        g.setColor(Color.black);
        //设置字体
        g.setFont(new Font("微软雅黑", Font.BOLD, 50));
        //注意:x,y为字符串左下角坐标
        g.drawString("Hello World!"+ '\n' + "你好, 世界", 100, 500);

        //画图片
        //获取图片资源, /mio.png表示在项目的根目录(D:\Java\idea_workspace\书\JavaSe_hsp\out\production\Chap16_TankBattle)
        //获取mio.png图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/mio.png"));
        g.drawImage(image, 500, 500, 143, 135, this);
    }
}
