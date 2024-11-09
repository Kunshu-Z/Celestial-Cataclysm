package com.github.KunshuZ.celestialcataclysm.renderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;


public class Window{
    static JFrame window = new JFrame();
    

    public static JFrame init() {
        window = new JFrame();
        window.setTitle("Celestial Cataclysm");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);

        return window;
    }


    public static <T extends JComponent> T add(T t, Object how){
        window.add(t, how);
        window.revalidate();
        window.repaint();
        return t;
    }

    public static <T extends JComponent> T add(T t){
        window.add(t);
        window.revalidate();
        window.repaint();
        return t;
    }

}


