package com.github.KunshuZ.celestialcataclysm.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.github.KunshuZ.celestialcataclysm.renderer.TileType;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;

public abstract class Game {
    public Game(){
        start();
    }

    public abstract void start();


}
