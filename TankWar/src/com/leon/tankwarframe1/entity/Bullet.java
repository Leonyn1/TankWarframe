package com.leon.tankwarframe1.entity;

import com.leon.tankwarframe1.constant.TankAttribute;
import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.control.TankController;
import com.leon.tankwarframe1.view.AppPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Description
 * <p>Create Time ：2023/12/28 23:17</p>
 *
 * @author ：Leon
 */
public class Bullet extends BasePanelObject implements Runnable {

    private int x;
    private int y;
    private int diameter;
    private TankDirect direct;
    private int speed = TankAttribute.DEFAULT_BULLET_SPEED;
    private Color color;

    public Bullet(int x, int y, TankDirect direct, JPanel panel) {
        super(panel);
        this.x = x;
        this.y = y;
        this.diameter = TankAttribute.DEFAULT_BULLET_DIAMETER;
        this.direct = direct;
        this.color = Color.WHITE;
    }

    @Override
    public void run() {
        JPanel panel = getPanel();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case UP:
                    this.y -= this.speed;
                    break;
                case DOWN:
                    this.y += this.speed;
                    break;
                case LEFT:
                    this.x -= this.speed;
                    break;
                case RIGHT:
                    this.x += this.speed;
                    break;
            }
            panel.repaint();
            if (!TankController.isAlive(this)) {
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TankDirect getDirect() {
        return direct;
    }

    public void setDirect(TankDirect direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }


}
