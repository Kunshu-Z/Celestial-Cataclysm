package com.github.KunshuZ.celestialcataclysm.renderer;
import java.awt.*;
import java.nio.file.Path;

import javax.swing.*;

import com.github.KunshuZ.celestialcataclysm.utils.Assets;



public abstract class Tile extends JComponent {
    abstract ImageIcon img();
    int x, y;
    @Override public Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }

    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img().getImage(), x, y, this);
    }

    public static class GrassTile extends Tile {
        public GrassTile(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override ImageIcon img() {
            return new ImageIcon(getClass().getResource("/grass.jpg"));
        }
    }

    public static class WaterTile extends Tile {
        public WaterTile(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override ImageIcon img() {throw new Error();}
        @Override protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, 10, 10);
        }
    }
}
