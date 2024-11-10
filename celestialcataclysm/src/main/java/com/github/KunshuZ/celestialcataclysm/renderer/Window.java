package com.github.KunshuZ.celestialcataclysm.renderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Window extends JFrame{
    static JFrame frame = new JFrame();
    static Canvas canvas = new Canvas();
    static int height = 800;
    static int width = 800;

    public static JFrame init() {
        frame = new JFrame();

        canvas.setPreferredSize(new Dimension(height, width));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.setTitle("Celestial Cataclysm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    public static <T extends JComponent> T add(T t){
        frame.add(t);
        frame.revalidate();
        frame.repaint();
        return t;
    }

}


