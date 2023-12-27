package com.leon.tankwarframe1.entity;

import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.constant.TankType;

import java.awt.*;

/**
 * Description
 * <p>Create Time ：2023/12/27 10:36</p>
 *
 * @author ：Leon
 */
public class EnemyTank extends Tank {

    public EnemyTank(int x, int y, TankDirect direct) {
        super(x, y, direct);
        setType(TankType.ENEMY);
        setColor(Color.YELLOW);
    }
}
