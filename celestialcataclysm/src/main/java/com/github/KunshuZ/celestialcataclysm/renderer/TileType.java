package com.github.KunshuZ.celestialcataclysm.renderer;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Optional;

interface TileTypeInterface{
    String src();
    default boolean walkable(){return true;}
    public default Image img(){
        return Optional.ofNullable(TileType.class.getResource(src()))
            .map(ImageIcon::new)
            .map(ImageIcon::getImage)
            .orElseThrow(()->new RuntimeException("Image "+src()+ "not found")); 
    }
}

public enum TileType implements TileTypeInterface{
    GRASS(){
        public String src(){return "/tiles/Grass-flat_large.png";}
    },
    WATER(){
        public String src(){return "/tiles/Water-01_large.png";}
        public boolean walkable(){return false;}
    },
    DIRT(){
        public String src(){return "/tiles/Ridge-04_large.png";}
    },
    CHARA(){
        public String src(){return "/sprites/overworld/character/chara_frount.png";}
    }

    ;

}
