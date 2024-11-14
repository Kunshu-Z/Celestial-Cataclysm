package com.github.KunshuZ.celestialcataclysm.engine;

public abstract class InteractableObject {
    protected int x, y;
    protected String dialogue;

    public InteractableObject(int x, int y, String dialogue) {
        this.x = x;
        this.y = y;
        this.dialogue = dialogue;
    }

    public abstract void interact();

}
