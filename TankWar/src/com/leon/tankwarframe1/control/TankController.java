package com.leon.tankwarframe1.control;

import com.leon.tankwarframe1.App;
import com.leon.tankwarframe1.entity.Bullet;
import com.leon.tankwarframe1.entity.Tank;
import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.view.AppPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Description
 * <p>Create Time ：2023/12/28 16:12</p>
 *
 * @author ：zhuwenlin
 */
public class TankController {
    private AppPanel appPanel;

    public TankController(AppPanel appPanel) {
        this.appPanel = appPanel;
    }

    public void tankMove(int keyCode, Tank tank) {
        if (keyCode == tank.getDirect().getValue()) {
            // 方向相同，进行移动
            doMove(keyCode, tank);
        }
        doTurn(keyCode, tank);
    }

    public void shoot(Set<Bullet> bullets, Tank tank) {
        bullets.add(tank.shoot());
    }

    public static boolean isAlive(Bullet bullet) {
        boolean isAlive = true;
        int x = bullet.getX();
        int y = bullet.getY();
        JPanel panel = bullet.getPanel();
        if (x < 0 || y < 0) {
            isAlive = false;
        }
        if (x > panel.getWidth() - bullet.getDiameter()) {
            isAlive = false;
        }
        if (y > panel.getHeight() - bullet.getDiameter()) {
            isAlive = false;
        }
        if (!isAlive) {
            ((AppPanel) panel).getBullets().remove(bullet);
        }
        return isAlive;
    }

    private void doMove(int keyCode, Tank tank) {
        if (keyCode == TankDirect.UP.getValue()
                && isOutBound(tank.getX(), tank.getY() - tank.getSpeed())) {
            tank.setY(tank.getY() - tank.getSpeed());
        } else if (keyCode == TankDirect.DOWN.getValue()
                && isOutBound(tank.getX(), tank.getY() + tank.getSpeed())) {
            tank.setY(tank.getY() + tank.getSpeed());
        } else if (keyCode == TankDirect.LEFT.getValue()
                && isOutBound(tank.getX() - tank.getSpeed(), tank.getY())) {
            tank.setX(tank.getX() - tank.getSpeed());
        } else if (keyCode == TankDirect.RIGHT.getValue()
                && isOutBound(tank.getX() + tank.getSpeed(), tank.getY() )) {
            tank.setX(tank.getX() + tank.getSpeed());
        }
    }

    private void doTurn(int keyCode, Tank tank) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                tank.setDirect(TankDirect.UP);
                break;
            case KeyEvent.VK_DOWN:
                tank.setDirect(TankDirect.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                tank.setDirect(TankDirect.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                tank.setDirect(TankDirect.RIGHT);
                break;
        }
    }

    private boolean isOutBound(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x > appPanel.getWidth() - 70) {
            return false;
        }
        if (y > appPanel.getHeight() - 70) {
            return false;
        }
        return true;
    }
}
