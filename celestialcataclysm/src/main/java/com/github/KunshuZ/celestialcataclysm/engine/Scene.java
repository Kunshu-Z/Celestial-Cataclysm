package com.github.KunshuZ.celestialcataclysm.engine;

import com.github.KunshuZ.celestialcataclysm.engine.TileMap;
import com.github.KunshuZ.celestialcataclysm.engine.Camera;
import com.github.KunshuZ.celestialcataclysm.engine.Controller;
import com.github.KunshuZ.celestialcataclysm.engine.View;
import com.github.KunshuZ.celestialcataclysm.engine.OverworldView;


import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Akin to scenes from Unity.
 * A scene object is a game state that has a controller (defines key bindings) and a view (defines how the scene is rendered) as well as some state
 */
public interface Scene {
    Controller controller();
    View view();   
    void ping();
}

record OverworldScene(TileMap map, Camera camera, View view, Controller controller) implements Scene{
    public OverworldScene{
        view.panel().setFocusable(true);
        view.panel().addKeyListener(controller);     
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
    public void ping(){}
}


//Battle Scene

//Menu Scene

//Title/Main Menu Scene

//Dialogue Scene


enum EmptyScene implements Scene{
    INSTANCE;
    public Controller controller(){return new Controller(Map.of(), Map.of());}
    public View view(){
        return new View(){
            JComponent panel = new JPanel();
            {panel.add(new JLabel("Empty Scene..."));}
            public JComponent panel() {return panel;}
            public void add(JComponent component, Object how) {}
            public void add(JComponent component) {}
            public void render() {}
        };
    }
    public void ping(){}
}