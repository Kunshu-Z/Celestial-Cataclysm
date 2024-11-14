package com.github.KunshuZ.celestialcataclysm.engine;

public class Player {
    private int x, y; //Player pos

    public void interact(InteractableObject obj){
        if(IsNear(obj)){
            obj.interact();
        }
    }

    private boolean IsNear(InteractableObject obj){
        //Defining the interaction range (50px)
        int range = 50;
        return Math.abs(this.x - obj.x) < range && Math.abs(this.y - obj.y) < range;
    }
}
