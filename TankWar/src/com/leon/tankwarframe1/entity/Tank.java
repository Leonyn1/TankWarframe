package com.leon.tankwarframe1.entity;

import com.leon.tankwarframe1.constant.TankAttribute;
import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.constant.TankType;

import javax.swing.*;
import java.awt.*;

/**
 * Description
 * <p>Create Time ：2023/12/27 10:24</p>
 *
 * @author ：Leon
 */
public class Tank extends BasePanelObject{
    private int x;
    private int y;
    private TankDirect direct;
    private TankType type;
    private Color color;
    private int speed = TankAttribute.DEFAULT_SPEED;


    public Tank(int x, int y, TankDirect direct, JPanel panel) {
        super(panel);
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Bullet shoot() {
        int x = this.x;
        int y = this.y;
        switch (this.direct) {
            case UP:
                x += 25;
                break;
            case DOWN:
                x += 25;
                y += 70;
                break;
            case LEFT:
                y += 25;
                break;
            case RIGHT:
                x += 70;
                y += 25;
                break;
        }
        Bullet bullet = new Bullet(x, y, this.direct, this.getPanel());
        new Thread(bullet).start();
        return bullet;
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

    public TankType getType() {
        return type;
    }

    public void setType(TankType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
