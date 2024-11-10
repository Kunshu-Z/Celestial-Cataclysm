package com.github.KunshuZ.celestialcataclysm.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.github.KunshuZ.celestialcataclysm.renderer.TileType;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;

public class Game {
    List<List<TileType>> tilemap = new ArrayList<>();
    public Game(){
        start();
    }

    public void start(){
        Window.init();
        assert SwingUtilities.isEventDispatchThread();

        // boolean running = true;
        // while(running){

        // }
    }



}
