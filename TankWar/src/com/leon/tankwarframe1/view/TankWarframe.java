package com.leon.tankwarframe1.view;

import com.leon.tankwarframe1.constant.TankDirect;
import com.leon.tankwarframe1.entity.EnemyTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Description
 * <p>Create Time ：2023/12/27 10:24</p>
 *
 * @author ：Leon
 */
public class TankWarframe extends JFrame {

    private AppPanel appPanel;

    public TankWarframe(AppPanel appPanel) {
        setAppPanel(new AppPanel());
        this.add(appPanel);
        this.addKeyListener(appPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setBackground(Color.BLACK);
    }

    public void setAppPanel(AppPanel appPanel) {
        this.appPanel = appPanel;
    }
}
