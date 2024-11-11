package com.github.KunshuZ.celestialcataclysm.engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
public class Controller implements KeyListener {
    enum keyState {PRESSED, RELEASED};
    record Key(int keyCode, keyState state) {}
    Map<Key, Runnable> keybinds;
    // public Controller(Map<Key, Runnable> keybinds) {
    //     this.keybinds = new HashMap<>(keybinds);
    // }

    public Controller(Map<Integer, Runnable> keybinds) {
        this.keybinds = keybinds.entrySet().stream()
            .collect(HashMap::new, (map, entry) -> map.put(new Key(entry.getKey(), keyState.PRESSED), entry.getValue()), HashMap::putAll);
    }
    
    public void bind(int keyCode, keyState state, Runnable action) {
        keybinds.put(new Key(keyCode, state), action);
    }

    public void unbind (int keyCode, keyState state) {
        keybinds.remove(new Key(keyCode, state));
    }

    @Override public void keyPressed(KeyEvent e) {
        e.consume();
        Optional.ofNullable(keybinds.get(new Key(e.getKeyCode(), keyState.PRESSED))).ifPresent(Runnable::run);
        
    }
    @Override public void keyReleased(KeyEvent e) {
        e.consume();
        Optional.ofNullable(keybinds.get(new Key(e.getKeyCode(), keyState.RELEASED))).ifPresent(Runnable::run);
    }
    @Override public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported.");
    }

}
