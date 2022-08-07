package tankGame05;

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

//为监听键盘, 需要实现KeyListener接口
//为了让Panel不停重绘子弹, 需要实现Runnable接口
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero;
    //定义敌人坦克, 并放入Vector中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector, 用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹的图片, 用于显示爆炸效果
    Image image1, image2, image3;

    public MyPanel() {
        hero = new Hero(100, 100, 0, 5);

        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 50, 2);
            //启动线程
            new Thread(enemyTank).start();
            //给enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX(), enemyTank.getY() + 35, enemyTank.getDirect());
            //将子弹加入到enemyTank的Vector对象
            enemyTank.shots.add(shot);
            //启动
            new Thread(shot).start();
            //将enemyTank加入集合
            enemyTanks.add(enemyTank);
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, TankGame05.WIDTH, TankGame05.HEIGHT); //地图底色

        //创建坦克
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }

        //画出Hero射击的子弹
//        if (hero.shot != null && hero.shot.isLive) {
//            g.fill3DRect(hero.shot.x-2, hero.shot.y-2, 4, 4, false);
//        }
//        System.out.println( "hero.shots.size() = " + hero.shots.size());
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.fill3DRect(shot.x-2, shot.y-2, 4, 4, false);
            } else {
                hero.shots.remove(shot);
            }
        }

        //如果bombs集合中有对象, 将它画出来
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > Bomb.MAX_LIFE * 2 / 3)
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            else if (bomb.life > Bomb.MAX_LIFE / 3)
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            else
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            //减少生命
            bomb.lifeDown();
            //如果life为0, 删去
            if (bomb.life <= 0) {
                bombs.remove(bomb);
            }
        }

        //画敌人
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);

            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画这个enemyTank的子弹
                //采用for i循环, 减少删除时的复杂度
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);

                    if (shot.isLive) {
                        g.fill3DRect(shot.x-2, shot.y-2, 4, 4, false);
                    } else {
                        //移除这颗子弹
                        enemyTank.shots.remove(j--);
                    }
                }
            } else {
                enemyTanks.remove(i--);
            }
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

    public void hitEnemyTank() {
        for (Shot shot : hero.shots) {
            for (EnemyTank enemyTank : enemyTanks) {
                if (enemyTank.isLive && shot.isLive) {
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    public void hitHero() {
        for (EnemyTank enemyTank: enemyTanks) {
            for (Shot shot: enemyTank.shots) {
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }

    public void hitTank(Shot s, Tank tank) {
        //判断s是否击中坦克
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if(tank.getX() - 20 <= s.x && s.x <= tank.getX() + 20
                    && tank.getY() - 30 <= s.y && s.y <= tank.getY() + 30) {
                    s.isLive = false;
                    tank.isLive = false;
                    bombs.add(new Bomb(tank.getX() - 30, tank.getY() - 30));
                }
                break;
            case 1:
            case 3:
                if(tank.getX() - 30 <= s.x && s.x <= tank.getX() + 30
                        && tank.getY() - 20 <= s.y && s.y <= tank.getY() + 20) {
                    s.isLive = false;
                    tank.isLive = false;
                    bombs.add(new Bomb(tank.getX() - 30, tank.getY() - 30));
                }
                break;
        }
//        System.out.println(bombs.size());
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
        //test code
        //System.out.println(hero);

        //如果按下J, 发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J){
            //发射一颗子弹
//            if (hero.shot == null || !hero.shot.isLive){
//                hero.shotEnemy();
//            }
            //发射多颗子弹
            hero.shotEnemy();
        }

        //如果按下
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("复活");
            hero.isLive = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //重绘用线程
        while (true) {
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中敌人
            hitEnemyTank();
            //判断自己是否被击中
            hitHero();

            this.repaint();
        }
    }
}
