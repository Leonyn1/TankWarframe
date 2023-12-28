package com.leon.tankwarframe1.view;

import com.leon.tankwarframe1.constant.TankAttribute;
import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.control.TankController;
import com.leon.tankwarframe1.entity.Hero;
import com.leon.tankwarframe1.entity.Bullet;
import com.leon.tankwarframe1.entity.Tank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * <p>Create Time ：2023/12/27 12:27</p>
 *
 * @author ：zhuwenlin
 */
public class AppPanel extends JPanel implements KeyListener {
    private Hero hero = null;
    private final TankController controller;
    private final Set<Bullet> bullets;


    public AppPanel() {
        hero = new Hero(TankAttribute.DEFAULT_X, TankAttribute.DEFAULT_Y, TankAttribute.DEFAULT_DIRECT, this);
        controller = new TankController(this);
        this.bullets = new HashSet<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        drawTank(hero, g);
        for (Bullet bullet : bullets) {
            drawBullet(bullet, g);
        }

    }

    /**
     * 画一个坦克
     *
     * @param tank {@link Tank}
     */
    public void drawTank(Tank tank, Graphics g) {
        int x = tank.getX();
        int y = tank.getY();
        g.setColor(tank.getColor());
        switch (tank.getDirect()) {
            case UP:
                g.fillArc(x, y, 10, 10, 0, 180);
                g.fillArc(x + 40, y, 10, 10, 0, 180);
                g.fillArc(x, y + 60, 10, 10, 180, 180);
                g.fillArc(x + 40, y + 60, 10, 10, 180, 180);
                g.fill3DRect(x, y + 5, 10, 60, false);
                g.fill3DRect(x + 10, y + 15, 30, 40, false);
                g.fill3DRect(x + 40, y + 5, 10, 60, false);
                g.fillOval(x + 10, y + 20, 30, 30);
                g.drawLine(x + 25, y + 35, x + 25, y);
                break;
            case DOWN:
                g.fillArc(x, y, 10, 10, 0, 180);
                g.fillArc(x + 40, y, 10, 10, 0, 180);
                g.fillArc(x, y + 60, 10, 10, 180, 180);
                g.fillArc(x + 40, y + 60, 10, 10, 180, 180);
                g.fill3DRect(x, y + 5, 10, 60, false);
                g.fill3DRect(x + 10, y + 15, 30, 40, false);
                g.fill3DRect(x + 40, y + 5, 10, 60, false);
                g.fillOval(x + 10, y + 20, 30, 30);
                g.drawLine(x + 25, y + 35, x + 25, y + 70);
                break;
            case LEFT:
                g.fillArc(x, y, 10, 10, 90, 180);
                g.fillArc(x + 60, y, 10, 10, 270, 180);
                g.fillArc(x, y + 40, 10, 10, 90, 180);
                g.fillArc(x + 60, y + 40, 10, 10, 270, 180);
                g.fill3DRect(x + 5, y, 60, 10, false);
                g.fill3DRect(x + 15, y + 10, 40, 30, false);
                g.fill3DRect(x + 5, y + 40, 60, 10, false);
                g.fillOval(x + 20, y + 10, 30, 30);
                g.drawLine(x + 35, y + 25, x, y + 25);
                break;
            case RIGHT:
                g.fillArc(x, y, 10, 10, 90, 180);
                g.fillArc(x + 60, y, 10, 10, 270, 180);
                g.fillArc(x, y + 40, 10, 10, 90, 180);
                g.fillArc(x + 60, y + 40, 10, 10, 270, 180);
                g.fill3DRect(x + 5, y, 60, 10, false);
                g.fill3DRect(x + 15, y + 10, 40, 30, false);
                g.fill3DRect(x + 5, y + 40, 60, 10, false);
                g.fillOval(x + 20, y + 10, 30, 30);
                g.drawLine(x + 35, y + 25, x + 70, y + 25);
                break;
        }
    }

    public void drawBullet(Bullet bullet, Graphics g) {
        g.setColor(bullet.getColor());
        int x = bullet.getX();
        int y = bullet.getY();
        int diameter = bullet.getDiameter();
        int halfDiameter = diameter / 2;
        switch (bullet.getDirect()) {
            case UP:
                x -= halfDiameter;
                y -= diameter;
                break;
            case DOWN:
                x -= halfDiameter;
                break;
            case LEFT:
                x -= diameter;
                y -= halfDiameter;
                break;
            case RIGHT:
                y -= halfDiameter;
                break;
        }
        g.fillOval(x, y, diameter, diameter);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.tankMove(e.getKeyCode(), hero);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_J:
                controller.shoot(bullets, hero);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Set<Bullet> getBullets() {
        return bullets;
    }
}
