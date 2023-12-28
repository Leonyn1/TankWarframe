package com.leon.tankwarframe1.control;

import com.leon.tankwarframe1.App;
import com.leon.tankwarframe1.entity.Tank;
import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.view.AppPanel;

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
