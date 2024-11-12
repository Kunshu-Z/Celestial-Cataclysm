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

        Scene demo = new OverworldScene( //create a scene
            new TileMap(new int[][]{
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 2, 1, 1, 1},
                {1, 1, 1, 2, 2, 1, 1, 1}
            }),
            new Camera(0, 0)
        );

        Stack<Scene> stateStack = new Stack<>();
        stateStack.push(demo);
        window.setScene(demo);

        //main game loop
        var tick = new AtomicInteger(0);
        Timer timer = new Timer(1000/30, e -> {
            tick.incrementAndGet();
            //window.ping();
            demo.ping();
            System.out.println("tick: " + tick.get());
        });
        timer.start();
    }

    
}
