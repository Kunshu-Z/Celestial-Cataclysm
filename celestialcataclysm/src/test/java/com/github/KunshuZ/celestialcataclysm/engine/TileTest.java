package com.github.KunshuZ.celestialcataclysm.engine;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.github.KunshuZ.celestialcataclysm.engine.TileMap;
import com.github.KunshuZ.celestialcataclysm.engine.Tile;
import com.github.KunshuZ.celestialcataclysm.engine.Camera;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import com.github.KunshuZ.celestialcataclysm.engine.OverworldView;



public class TileTest {
    public static void displayTile(){
        var tile = Tile.panel(0, 0, Tile.GRASS);
        var window = new Window("");
        window.add(tile);
    }    

    public static void display2dArrayOfTiles() {
        var tilemap = new TileMap(new int[][]{
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2},
            {1, 1, 1, 2, 2}
        });
        var window = new Window("");
        var camera = new Camera(0, 0);



        //window.setView(new OverworldView(tilemap, camera));
        
        // int tileSize = Tile.tileSize;    
        // for (int i = 0; i < tilemap.size(); i++) {
        //     for (int j = 0; j < tilemap.get(i).size(); j++) {
        //         var tile = tilemap.get(i).get(j);
        //         JPanel panel = new JPanel() {
        //             @Override protected void paintComponent(Graphics g) {
        //                 super.paintComponent(g);
        //                 g.drawImage(tile.img(), 0, 0, tileSize, tileSize, null);
        //             }
        //         };
        //         panel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
        //         layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
        //     }
        // }
        window.ping();
    }  
    
    public static void main(String[] args){
        //displayTile();
        display2dArrayOfTiles();
    }
}


