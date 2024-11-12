package com.github.KunshuZ.celestialcataclysm.engine;

import com.github.KunshuZ.celestialcataclysm.engine.TileMap;
import com.github.KunshuZ.celestialcataclysm.engine.Camera;
import com.github.KunshuZ.celestialcataclysm.engine.Controller;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.OverworldView;

import java.awt.event.KeyEvent;
import java.util.Map;




public interface Scene {
    Controller controller();
    View view();   
    void ping();
}

record OverworldScene(TileMap map, Camera camera, View view, Controller controller) implements Scene{
    public OverworldScene{
        view().panel().setFocusable(true);
        view().panel().addKeyListener(controller());     
    }

    //this constructor
    public OverworldScene(TileMap map, Camera camera){
        this(map, camera, View.Overworld(map, camera), new Controller(Map.of(
            KeyEvent.VK_UP, () -> camera.move(0, -1),
            KeyEvent.VK_DOWN, () -> camera.move(0, 1),
            KeyEvent.VK_LEFT, () -> camera.move(-1, 0),
            KeyEvent.VK_RIGHT, () -> camera.move(1, 0)
        ), Map.of()));
    }

    public Controller controller(){
        return new Controller(Map.of(
            KeyEvent.VK_UP, () -> camera.move(0, -1),
            KeyEvent.VK_DOWN, () -> camera.move(0, 1),
            KeyEvent.VK_LEFT, () -> camera.move(-1, 0),
            KeyEvent.VK_RIGHT, () -> camera.move(1, 0)
        ), Map.of());
    }
    public View view(){
        return (OverworldView) View.Overworld(map, camera);
    }
    public void ping(){
        view().render();
    }
}