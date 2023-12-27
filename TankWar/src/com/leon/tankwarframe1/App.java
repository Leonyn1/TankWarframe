package com.leon.tankwarframe1;

import com.leon.tankwarframe1.view.AppPanel;
import com.leon.tankwarframe1.view.TankWarframe;

/**
 * Description
 * <p>Create Time ：2023/12/27 12:38</p>
 *
 * @author ：zhuwenlin
 */
public class App {
    public static void main(String[] args) {
        TankWarframe tankWarframe = new TankWarframe(new AppPanel());
    }
}
