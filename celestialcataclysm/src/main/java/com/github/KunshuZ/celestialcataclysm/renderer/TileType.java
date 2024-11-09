package com.github.KunshuZ.celestialcataclysm.renderer;
import javax.swing.ImageIcon;
import java.awt.Image;

public enum TileType {
    GRASS(new ImageIcon(TileType.class.getResource("/grass.jpg"))),
    WATER(new ImageIcon(TileType.class.getResource("/grass.jpg")));
    private ImageIcon img = new ImageIcon(TileType.class.getResource("/grass.jpg"));
    TileType(ImageIcon img){this.img = img;}
    public Image img(){return img.getImage();}
}
