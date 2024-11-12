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
    private Scene scene;
    private View view;

    public Window(String title){
        super();
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(height, width);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setScene(Scene scene){
        this.scene = scene;
        this.setView(scene.view());        
    }

    public void setView(View view){
        this.view = view;
        this.add(view.panel());
        view.render();
        view.panel().setFocusable(true);
        view.panel().addKeyListener(scene.controller());
    }


    public void ping(){
        this.repaint();
        this.revalidate();
        view.render();
    }
    
    /**
     * puts too much importance on the window class
     */
    // public <T extends JComponent> T add(T t, Object how){
    //     //this.add(t, how);
    //     view.add(t, how);
    //     return t;
    // }
    // public void setController(Controller controller){
    //     this.addKeyListener(controller);        
    // }
}
