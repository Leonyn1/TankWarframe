package com.leon.tankwarframe1.constant;

/**
 * Description
 * <p>Create Time ：2023/12/27 10:29</p>
 *
 * @author ：Leon
 */
public enum TankDirect {
    UP(0x26),
    DOWN(0x28),
    LEFT(0x25),
    RIGHT(0x27);

    private final int value;

    TankDirect(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
