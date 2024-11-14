package com.github.KunshuZ.celestialcataclysm.engine;

import java.util.Map;
import java.util.HashMap;

public class DialogueManager {
    private Map<String, String> dialogues; //Map containing String as key and index

    public DialogueManager() {
        dialogues = new HashMap<>();
        dialogues.put("NPC1", "Hello this is a test!");
        dialogues.put("Obj1", "This is an interactable object...");
    }

    public String getDialogue(String key) {
        return dialogues.getOrDefault(key, "...");
    }
}
