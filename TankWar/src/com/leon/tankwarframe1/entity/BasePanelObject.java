package com.leon.tankwarframe1.entity;

import javax.swing.*;

/**
 * Description
 * <p>Create Time ：2023/12/28 23:38</p>
 *
 * @author ：Leon
 */
public class BasePanelObject {
    private JPanel panel;

    public JPanel getPanel() {
        return panel;
    }

    public BasePanelObject(JPanel panel) {
        this.panel = panel;
    }
}
