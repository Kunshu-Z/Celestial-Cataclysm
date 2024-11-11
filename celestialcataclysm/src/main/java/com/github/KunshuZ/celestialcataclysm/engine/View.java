package com.github.KunshuZ.celestialcataclysm.engine;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.util.stream.IntStream;

public interface View {
    JComponent panel();
    void render();
    default void add(JComponent component, Object how){panel().add(component, how);}
    default void add(JComponent component){add(component, null);}
    public static View Overworld(TileMap tileMap, Camera camera){return new OverworldView(tileMap, camera);}
}

class OverworldView implements View {
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
        panel.setLayout(null);        
    }

    public JComponent panel() {return panel;}

    public void render(){
        panel.removeAll();
        int centerX = (width-1)/2;
        int centerY = (height-1)/2;
        int offsetX = centerX - camera.x();
        int offsetY = centerY -camera.y();

        IntStream.range(0, height).forEach(y ->
            IntStream.range(0, width).forEach(x -> {
                var xid = x - offsetX;
                var yid = y - offsetY;
                var tileType = tileMap.getTile(yid, xid);
                var tilePanel = Tile.panel(x, y, tileType);
                panel.add(tilePanel);
            })
        );

        panel.add(Tile.panel(centerX, centerY, Tile.CHARA), Integer.valueOf(1)); //add the character tile at the center of the rendering window
        panel.repaint();
    }
}


class NullView implements View {
    JComponent panel = new JPanel();
    {panel.add(new JLabel("sdasdadsaasdasdsa"));}
    public JComponent panel() {return panel;}
    public void add(JComponent component, Object how) {}
    public void add(JComponent component) {}
    public void render() {}
}
