package com.github.KunshuZ.celestialcataclysm.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Player player;
    private List<InteractableObject> interactableObjects; //List of interactables

    public GamePanel(Player player, List<InteractableObject> interactableObjects){
        this.player = player;
        this.interactableObjects = interactableObjects;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_Z){
                    checkInteractions();
                }
            }
        });
        setFocusable(true);
    }

    private void checkInteractions() {
        for(InteractableObject obj : interactableObjects) {
            player.interact(obj);
        }
    }
}
