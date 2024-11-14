package com.github.KunshuZ.celestialcataclysm.engine;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogueBox extends JDialog {
    private JLabel dialogueLabel;

    public DialogueBox(JFrame parent){
        super(parent, "Dialogue", true);
        dialogueLabel = new JLabel();
        add(dialogueLabel);
        setSize(300, 150);
    }

    public void showDialogue(String dialogue){
        dialogueLabel.setText(dialogue);
        setVisible(true);
    }
}
