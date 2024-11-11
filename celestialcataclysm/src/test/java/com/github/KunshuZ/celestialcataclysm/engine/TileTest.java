package com.github.KunshuZ.celestialcataclysm.engine;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.github.KunshuZ.celestialcataclysm.engine.TileMap;



public class TileTest {
    public static void displayTile(){
        var tile = Tile.panel(0, 0, Tile.GRASS);
        //Window.init();
        Window.add(tile);
    }    

    public static void display2dArrayOfTiles() {
        List<List<Tile>> tilemap = new TileMap(new int[][]{
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2},
            {1, 1, 1, 2, 2}
        }).tilemap;
        //Window.init();
        var window = Window.frame;
        var layeredPane = new JLayeredPane();
        window.setContentPane(layeredPane);
        window.setLayout(null);
        int tileSize = Tile.tileSize;    
        for (int i = 0; i < tilemap.size(); i++) {
            for (int j = 0; j < tilemap.get(i).size(); j++) {
                var tile = tilemap.get(i).get(j);
                JPanel panel = new JPanel() {
                    @Override protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(tile.img(), 0, 0, tileSize, tileSize, null);
                    }
                };
                panel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
                layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
            }
        }

        //draw player ontop of the tilemap
        JPanel characterTile = Tile.panel(2, 2, Tile.CHARA);
        layeredPane.add(characterTile, JLayeredPane.PALETTE_LAYER);
        //make it transparent
        characterTile.setOpaque(false);

        window.setVisible(true);
    }  
    
    public static void main(String[] args){
        //displayTile();
        display2dArrayOfTiles();
    }
}


