package com.github.KunshuZ.celestialcataclysm.engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

/**
 * Object that defines key bindings for a scene.
 * Maps are key codes to actions. Actions are objects with a single method/function that will be ran when the key is pressed or released.
 */
public record Controller(Map<Integer, Runnable> onPress, Map<Integer, Runnable> onRelease) implements KeyListener{
    public Controller(){
        this(new HashMap<>(), new HashMap<>());
    }
    public void keyPressed(KeyEvent e) {
        e.consume();
        Optional.ofNullable(onPress.get(e.getKeyCode())).ifPresent(r->r.run());
    }
    public void keyReleased(KeyEvent e) {
        e.consume();
        Optional.ofNullable(onRelease.get(e.getKeyCode())).ifPresent(r->r.run());
    }
    public void keyTyped(KeyEvent e) {}
}