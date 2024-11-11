package com.github.KunshuZ.celestialcataclysm.main;
import com.github.KunshuZ.celestialcataclysm.engine.Tile;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import com.github.KunshuZ.celestialcataclysm.engine.TileMap;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import com.github.KunshuZ.celestialcataclysm.engine.Camera;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.Controller;
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




public abstract class Game {
    public abstract void start();
    public Game(){
        start();
    }
}
class CelestialCataclysm extends Game {
    public void start(){
        assert SwingUtilities.isEventDispatchThread(); //make sure the current thread is the event dispatch thread

        var window = new Window("CelestialCataclysm");
        TileMap tileMap = new TileMap(new int[][]{
            {0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1}
        });
        Camera camera = new Camera(0, 0);
        View overWorldView = View.Overworld(tileMap, camera);
        window.setView(overWorldView);
        Controller controller = new Controller(Map.of(
            KeyEvent.VK_UP, () -> camera.move(0, -1),
            KeyEvent.VK_DOWN, () -> camera.move(0, 1),
            KeyEvent.VK_LEFT, () -> camera.move(-1, 0),
            KeyEvent.VK_RIGHT, () -> camera.move(1, 0)
        ));
        window.addKeyListener(controller);

        //main game loop
        AtomicInteger tick = new AtomicInteger(0);
        Timer timer = new Timer(1000/30, e -> {
            tick.incrementAndGet();
            window.ping();
            System.out.println("tick: " + tick.get());
        });
        timer.start();
    }
}
