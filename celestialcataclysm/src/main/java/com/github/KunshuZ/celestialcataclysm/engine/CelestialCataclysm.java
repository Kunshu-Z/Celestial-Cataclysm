package com.github.KunshuZ.celestialcataclysm.engine;
import java.util.List;
import java.util.function.Function;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.util.Stack;

abstract class Game {
    public abstract void start();
    public Game(){
        start();
    }
}

public class CelestialCataclysm extends Game {
    public void start(){
        assert SwingUtilities.isEventDispatchThread(): "computation should be in the rendering thread";
        
        Window window = new Window("CelestialCataclysm"); //main window for the progra,

        Scene route1 = new OverworldScene( //create a scene
            new TileMap(new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 2, 1, 1, 1},
                {1, 1, 1, 2, 2, 1, 1, 1}
            }),
            new Camera(0, 0)
        );
        Scene route2 = new OverworldScene(
            new TileMap(new int[][]{
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 2, 2, 1, 1, 0},
                {1, 1, 2, 3, 3, 2, 1, 1},
                {1, 2, 3, 4, 4, 3, 2, 1},
                {1, 2, 3, 4, 4, 3, 2, 1},
                {1, 1, 2, 3, 3, 2, 1, 1},
                {0, 1, 1, 2, 2, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0}
            }),
            new Camera(2, 2)
        );

        SceneManager scenes = new SceneManager(route1);
        scenes.push(route1);

        window.setScene(scenes);

        //main loop
        var tick = new AtomicInteger(0);
        Timer timer = new Timer(1000/30, e -> {
            window.ping();

            if(tick.get() == 200){
                scenes.push(route2);
            }



            System.out.println("tick: " + tick.incrementAndGet());
        });
        timer.start();
    }

    
}
