package com.github.KunshuZ.celestialcataclysm.main;
import javax.swing.*;
import java.awt.*;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(Window::display); //run/compute Window.display() on the rendering thread 
        SwingUtilities.invokeLater(()->Window.add(new Circle(), BorderLayout.CENTER)); 
    }
}

//temporary
class Circle extends JPanel{
    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED); // Set color for shapes
        g2d.fillOval(0, 0, 100, 100); // Fill oval
    }
}

class Tile extends JPanel{
   // ImageIcon img = new ImageIcon(getClass().getResource("/resources/grass.jpg"));
    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(img.getImage(), 0, 0, this);
    }
}