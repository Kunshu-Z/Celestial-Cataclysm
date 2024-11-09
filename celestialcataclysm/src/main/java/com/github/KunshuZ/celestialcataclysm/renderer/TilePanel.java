package com.github.KunshuZ.celestialcataclysm.renderer;
import java.awt.*;
import java.nio.file.Path;
import javax.swing.*;
import com.github.KunshuZ.celestialcataclysm.utils.Assets;



public class TilePanel extends JPanel {

    int x;
    int y;
    TileType tileType;

    //Screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //To produce a 48x48 tile effect
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow; 

    Thread gameThread;

    public TilePanel(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread();
        gameThread.start();
    }
    
    @Override public Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }

    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(tileType.img(), 0, 0, this);
        this.setBounds(y * tileSize, x * tileSize, tileSize, tileSize);
    }
}
