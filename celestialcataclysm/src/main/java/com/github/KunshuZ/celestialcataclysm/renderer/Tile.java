package com.github.KunshuZ.celestialcataclysm.renderer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Optional;
import java.awt.Dimension;
import java.awt.Color;



public enum Tile {
    BLANK(-1, "/tiles/Water-01_large.png", true),
    GRASS(0, "/tiles/Grass-flat_large.png", true),
    WATER(1,"/tiles/Water-01_large.png", true),
    DIRT(2,"/tiles/Ridge-04_large.png", true),
    CHARA(3,"/sprites/overworld/character/chara_frount.png", true);

    private final String src;
    private final boolean walkable;
    int id;

    static final int originalTileSize = 16;
    static final int scale = 3;
    public static final int tileSize = originalTileSize * scale; //To produce a 48x48 tile effect
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow; 

    private Tile(int id, String src, boolean walkable) {
        this.id = id;
        this.src = src;
        this.walkable = walkable;
    }

    public static Tile fromId(int id) {
        for (Tile t : Tile.values()) {
            if (t.id == id) {
                return t;
            }
        }
        return BLANK;
    }

    public static JPanel panel(int x, int y, Tile tileType) {
        var p = new JPanel(){
            @Override protected void paintComponent(java.awt.Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(tileType.img(), 0, 0, tileSize, tileSize, null);
            }
            
            {
                this.setPreferredSize(new Dimension(Window.width, Window.height));
                this.setBackground(Color.BLACK);
                this.setDoubleBuffered(true);
                this.setOpaque(false);
            }
        };
        p.setBounds(x*tileSize, y*tileSize, tileSize, tileSize);
        return p;
    }

    public String getSrc() {return src;}
    public boolean isWalkable() {return walkable;}
    public Image img() {
        return Optional.ofNullable(Tile.class.getResource(src))
                .map(ImageIcon::new)
                .map(ImageIcon::getImage)
                .orElseThrow(() -> new RuntimeException("Image " + src + " not found"));
    }
}
