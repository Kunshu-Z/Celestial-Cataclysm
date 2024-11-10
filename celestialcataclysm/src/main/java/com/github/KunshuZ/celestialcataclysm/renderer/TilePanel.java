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
    static final int originalTileSize = 16;
    static final int scale = 3;

    public static final int tileSize = originalTileSize * scale; //To produce a 48x48 tile effect
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow; 

    public TilePanel(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        //this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        //this.setBackground(Color.BLACK);
        //this.setDoubleBuffered(true);
    }


    // @Override public Dimension getPreferredSize() {
    //     return new Dimension(10, 10);
    // }

    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(tileType.img(), 0, 0, 100, 100, null);
    }


    public static JPanel of(int x, int y, TileType tileType) {
        var p = new JPanel(){
            @Override protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(tileType.img(), 0, 0, tileSize, tileSize, null);
            }
        };
        p.setBounds(x*TilePanel.tileSize, y*TilePanel.tileSize, TilePanel.tileSize, TilePanel.tileSize);
        return p;
    }
}
