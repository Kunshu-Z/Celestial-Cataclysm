package com.github.KunshuZ.celestialcataclysm.renderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

abstract class View extends JFrame{}

public class Window extends View{
    static int width = 800;
    static int height = 800;
    static JFrame frame = new JFrame();

    static JComponent content = new JLayeredPane();


    public static JFrame init() {
        frame = new JFrame();

        frame.setTitle("Celestial Cataclysm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.setContentPane(content);
        frame.setLayout(null);

        return frame;
    }

    public static <T extends JComponent> T add(T t){
        content.add(t);
        frame.revalidate();
        frame.repaint();
        return t;
    }

    public static void ping(){
        frame.repaint();
    }

}


