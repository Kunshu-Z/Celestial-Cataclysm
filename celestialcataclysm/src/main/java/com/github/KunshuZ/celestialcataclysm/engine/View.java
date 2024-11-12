package com.github.KunshuZ.celestialcataclysm.engine;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.util.stream.IntStream;
import java.awt.Graphics;

/**
 * Class that represents a what type of view is being rendered.
 */
public abstract class View extends JComponent{
    abstract void render();
    abstract JComponent panel();
    //TODO: wrong and inconsistent due to overworld view compositing an inner panel. fix this 
    void add(JComponent component, Object how){this.add(component, how);}
    void add(JComponent component){this.add(component, null);}
    public static View Overworld(TileMap tileMap, Camera camera){return new OverworldView(tileMap, camera);}
}

/**
 * Will render a view of the overworld based on a given tile map and camera.
 */
class OverworldView extends View {
    JComponent panel;
    int aspect = (5*3) +1;
    int width = aspect;
    int height = aspect;
    TileMap tileMap;
    Camera camera;

    public OverworldView(TileMap tileMap, Camera camera){
        assert width % 2 == 1 && height % 2 == 1 : "Width and height must be odd"; 
        panel = new JLayeredPane();
        this.tileMap = tileMap;
        this.camera = camera;
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        panel.paint(g);
    }
    public JComponent panel() {return panel;}

    public void render(){
        panel.removeAll();
        int centerX = (width-1)/2;
        int centerY = (height-1)/2;
        int offsetX = centerX - camera.x();
        int offsetY = centerY -camera.y();

        IntStream.range(0, height).parallel().forEach(y ->
            IntStream.range(0, width).parallel().forEach(x -> {
                var tileType = tileMap.getTile(y - offsetY, x - offsetX);
                var tilePanel = Tile.panel(x, y, tileType);
                synchronized (panel) {panel.add(tilePanel);}
            })
        );

        panel.add(Tile.panel(centerX, centerY, Tile.CHARA), Integer.valueOf(1)); //add the character tile at the center of the rendering window
        panel.repaint();
    }
}