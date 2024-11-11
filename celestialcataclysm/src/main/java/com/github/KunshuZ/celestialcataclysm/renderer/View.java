package com.github.KunshuZ.celestialcataclysm.renderer;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

public interface View {
    JComponent panel();
    default void add(JComponent component, Object how){
        panel().add(component, how);
    }
    default void add(JComponent component){
        add(component, null);
    }

    
    public static View OverWorldView(){
        return new OverWorldView();
    }
    public static View NullView(){
        return new NullView();
    }
}

class OverWorldView implements View {
    JComponent panel;

    {
        panel = new JLayeredPane();
        panel.setLayout(null);

        
    }

    public JComponent panel() {
        panel.setLayout(null);
        return panel;
    }


}


class NullView implements View {
    JComponent panel = new JPanel();
    {panel.add(new JLabel("sdasdadsaasdasdsa"));}
    public JComponent panel() {return panel;}
    public void add(JComponent component, Object how) {}
    public void add(JComponent component) {}
}

interface GameMenuView extends View {

}



interface BattleView extends View {

}

interface DialogueView extends View {

}

