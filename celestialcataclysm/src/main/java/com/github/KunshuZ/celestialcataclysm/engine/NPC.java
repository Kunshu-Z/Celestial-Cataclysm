package com.github.KunshuZ.celestialcataclysm.engine;

public class NPC extends InteractableObject {
    private DialogueBox dialogueBox;
    private String dialogueKey;
    private DialogueManager dialogueManager;

    public NPC(int x, int y, String dialogue, DialogueBox dialogueBox, String dialogueKey, DialogueManager dialogueManager) {
        super(x, y, dialogue);
        this.dialogueBox = dialogueBox;
        this.dialogueKey = dialogueKey;
        this.dialogueManager = dialogueManager;
    }

    @Override
    public void interact(){
        dialogueBox.showDialogue(dialogueManager.getDialogue(dialogueKey)); //To show the dialogue in a textbox
    }
}
