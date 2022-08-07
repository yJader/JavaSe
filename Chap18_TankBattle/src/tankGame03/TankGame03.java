package tankGame03;

import javax.swing.*;

/**
 * @Author yJade
 * @Date 2022-07-14 14:56
 * @Package com.hsp.tankGame
 */
public class TankGame03 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    static final int WIDTH = 1600;
    static final int HEIGHT = 900;

    public static void main(String[] args) {
        TankGame03 tankGame03 = new TankGame03();
    }

    public TankGame03() {
        mp = new MyPanel();
        //静态代理
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //将面板(游戏绘图区域加入)

        this.setSize(WIDTH, HEIGHT); //窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
        this.setVisible(true);
    }
}

/**
 * 2022年7月21日 23:43:45
 * 想添加变量width和height, 但是出现了java.lang.NullPointerException异常
 * 最后用static final常量
 */
