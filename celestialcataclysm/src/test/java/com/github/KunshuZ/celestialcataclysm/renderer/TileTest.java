package com.github.KunshuZ.celestialcataclysm.renderer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.github.KunshuZ.celestialcataclysm.renderer.TileMap;



public class TileTest {
    public static void displayTile(){
        TilePanel tile = new TilePanel(0,0, TileType.GRASS);
        Window.init();
        Window.add(tile);
    }    

    public static void display2dArrayOfTiles() {
        // List<List<TileType>> tilemap = List.of(
        //     List.of(TileType.GRASS, TileType.GRASS, TileType.GRASS),
        //     List.of(TileType.GRASS, TileType.GRASS, TileType.GRASS),
        //     List.of(TileType.GRASS, TileType.GRASS, TileType.GRASS)
        // );
        
        List<List<TileType>> tilemap = new TileMap(new int[][]{
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2},
            {1, 1, 1, 2, 2}
        }).tilemap;
        Window.init();
        var window = Window.frame;
        var layeredPane = new JLayeredPane();
        window.setContentPane(layeredPane);
        window.setLayout(null);
    
        int tileSize = 100; // Assuming each tile is 80x80 pixels
    
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
        // JPanel character = new JPanel() {
        //     @Override protected void paintComponent(Graphics g) {
        //         super.paintComponent(g);
        //         g.drawImage(TileType.CHARA.img(), 0, 0, tileSize, tileSize, null);
        //     }
        // };
        // character.setOpaque(false);
        // character.setBounds(1 * tileSize, 1 * tileSize, tileSize, tileSize);
        // layeredPane.add(character, JLayeredPane.PALETTE_LAYER);
        //window.pack();
        window.setVisible(true);
    }  
    
    public static void main(String[] args){
        //displayTile();
        display2dArrayOfTiles();
    }
}


