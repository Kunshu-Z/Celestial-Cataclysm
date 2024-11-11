package com.github.KunshuZ.celestialcataclysm.main;
import com.github.KunshuZ.celestialcataclysm.engine.Tile;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import com.github.KunshuZ.celestialcataclysm.engine.TileMap;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import com.github.KunshuZ.celestialcataclysm.engine.Camera;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import java.util.List;
import java.util.function.Function;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.stream.IntStream;
import java.util.ArrayList;


public abstract class Game {
    public abstract void start();
    public Game(){
        start();
    }
}
class CelestialCataclysm extends Game {
    public void start(){
        
        Window.init(); //initialize the main window for the program
        Window.setView(View.OverWorldView());

        assert SwingUtilities.isEventDispatchThread(); //make sure the current thread is the event dispatch thread


        
        //nested loop over 2d array of tiles and adding them to the window
        // IntStream.range(0, map.height()).forEach(y ->
        //     IntStream.range(0, map.width()).forEach(x -> {
        //         var tileType = map.getTile(y, x);
        //         var tilePanel = Tile.panel(x, y, tileType);
        //         Window.add(tilePanel);
        //     })
        // );

        Window.view.render();
        



        //main game loop
        int[] tick = {0};
        Timer timer = new Timer(1130, e -> {
            tick[0]++;
            Window.ping();
            System.out.println("tick: " + tick[0]);
            ((Timer) e.getSource()).stop(); // Stop the timer after the first tick
        });
        timer.setRepeats(false); // Ensure the timer only ticks once
        timer.start();
    }
}
