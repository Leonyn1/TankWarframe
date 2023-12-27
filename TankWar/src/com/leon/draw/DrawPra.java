package com.leon.draw;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Description
 * <p>Create Time ：2023/12/26 23:08</p>
 *
 * @author ：Leon
 */
public class DrawPra extends JFrame{
    private Panel_ pa = null;
    public static void main(String[] args) {
//        DrawPra drawPra = new DrawPra();
        List<String> strings;
        try {
             strings = Files.readAllLines(Paths.get("E:\\Document\\code\\file\\test.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public DrawPra() {
        pa = new Panel_();
        this.add(pa);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Panel_ extends JPanel {

    @Override
    public void paint(Graphics g) {
        System.out.println("paint is diaoyong");
        // 调用父类对象完成初始化
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.BLUE);
        g.fill3DRect(40, 40, 40, 40, true);
    }
}
