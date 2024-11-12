package com.github.KunshuZ.celestialcataclysm.engine;

/**
 * x and y coordinates of the camera on a top down view of an over world view.
 * Coords point to the position where the character will be drawn on the screen.
 * The camera will move with the character.
 * 
 */
public class Camera {   
    int x, y;
    public Camera(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x(){return x;}
    public int y(){return y;}
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
}
