package com.github.KunshuZ.celestialcataclysm.renderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Window extends JFrame{
    public static int width = 800;
    public static int height = 800;
    public static JFrame frame;
    public static View view;

    public static void init(){
        frame = new JFrame();
        
        frame.setTitle("Celestial Cataclysm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        frame.setResizable(false);
        frame.setVisible(true);

        //content = new JLayeredPane();
        //frame.setContentPane(content);
        view = View.NullView();
    }

    public static void setView(View view){
        Window.view = view;
        frame.add(view.panel());
        frame.setContentPane(view.panel());
        frame.setLayout(null);
    }

    public static void ping(){
        frame.repaint();
        frame.revalidate();
    }

    public static <T extends JComponent> T add(T t, Object how){
        view.add(t, how);
        ping();
        return t;
    }

    public static <T extends JComponent> T add(T t){return add(t, null);}
}
