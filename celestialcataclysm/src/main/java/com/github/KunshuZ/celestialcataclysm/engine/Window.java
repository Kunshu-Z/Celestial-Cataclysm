package com.github.KunshuZ.celestialcataclysm.engine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Window extends JFrame{
    public static final int width = ((5*3)+1)*48;
    public static final int height = ((5*3)+1)*48;
    private JFrame frame;
    private View view;

    public Window(String title){
        frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(height, width);
        frame.setResizable(false);
        frame.setVisible(true);
        view = new NullView();
    }

    public void setView(View view){
        this.view = view;
        frame.add(view.panel());
        frame.setContentPane(view.panel());
        frame.setLayout(null);
    }

    public void ping(){
        frame.repaint();
        frame.revalidate();
        view.render();
    }

    public void addKeyListener(Controller controller){
        frame.addKeyListener(controller);
    }

    public <T extends JComponent> T add(T t, Object how){
        view.add(t, how);
        ping();
        return t;
    }
    public <T extends JComponent> T add(T t){return add(t, null);}
}
