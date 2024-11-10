package com.github.KunshuZ.celestialcataclysm.main;
import com.github.KunshuZ.celestialcataclysm.renderer.TileMap;
import com.github.KunshuZ.celestialcataclysm.renderer.TilePanel;
import com.github.KunshuZ.celestialcataclysm.renderer.TileType;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;

import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.stream.IntStream;



public class CelestialCataclysm extends Game {
    Model m;


    public void start(){
        Window.init();
        assert SwingUtilities.isEventDispatchThread();

        TileMap map = new TileMap(new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2},
            {1, 1, 1, 2, 2}
        });
    
        IntStream.range(0, map.height()).forEach(x ->
            IntStream.range(0, map.width()).forEach(y ->
                Window.add(TilePanel.of(y, x, map.getTile(x, y)))
            )
        );

        //eww for loop
        //boolean running = true;
        // while(running){
        //     System.out.println("ping");
        // }

        //based OOP and lambda
        Timer timer= new Timer(30, unused->{
            assert SwingUtilities.isEventDispatchThread();
            //m.ping();
            Window.ping();
            System.out.println("ping");
        });
        timer.start();
    }
}
