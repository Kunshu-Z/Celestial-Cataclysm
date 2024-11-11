package com.github.KunshuZ.celestialcataclysm.main;
import com.github.KunshuZ.celestialcataclysm.renderer.Tile;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;
import com.github.KunshuZ.celestialcataclysm.renderer.TileMap;
import com.github.KunshuZ.celestialcataclysm.renderer.View;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;
import com.github.KunshuZ.celestialcataclysm.renderer.Camera;
import com.github.KunshuZ.celestialcataclysm.renderer.View;
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

        /**
         * place holder tile map
         */
        TileMap map = new TileMap(new int[][]{
            {0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1}
        });
        
        //nested loop over 2d array of tiles and adding them to the window
        IntStream.range(0, map.height()).forEach(y ->
            IntStream.range(0, map.width()).forEach(x -> {
                var tileType = map.getTile(y, x);
                var tilePanel = Tile.panel(x, y, tileType);
                Window.add(tilePanel);
            })
        );
        
        JPanel characterTile = Tile.panel(2, 2, Tile.CHARA);

        Window.add(characterTile, Integer.valueOf(1));

        Camera c = new Camera(2,2);


        //main game loop
        int[] tick = {0};
        Timer timer = new Timer(30, e->{
            tick[0]++;
            Window.ping();
            System.out.println("tick: " + tick[0]);

        });
        timer.start();
    }
}
