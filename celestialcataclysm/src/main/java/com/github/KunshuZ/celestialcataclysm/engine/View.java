package com.github.KunshuZ.celestialcataclysm.engine;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.util.stream.IntStream;

public interface View {
    JComponent panel();
    void render();
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
    int width = (5*3) +1;
    int height = width;
    TileMap tileMap = new TileMap(new int[][]{
        {0, 0, 0, 0, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 2, 2, 1, 1, 1},
        {1, 1, 1, 2, 2, 1, 1, 1}
    });

    Camera camera = new Camera(1, 0);

    {
        assert width % 2 == 1 && height % 2 == 1 : "Width and height must be odd"; 
        panel = new JLayeredPane();
        panel.setLayout(null);        
    }

    public JComponent panel() {
        panel.setLayout(null);
        return panel;
    }

    public void render(){
        panel.removeAll();



        //center coords to the tile at  the center of the rendering window
        int renderWindowCenterX = (width-1) / 2;
        int renderWindowCenterY = (height-1) / 2;

        //difference between the center of the rendering window and the camera
        int offsetX = renderWindowCenterX - camera.x() ;
        int offsetY = renderWindowCenterY -camera.y() ;

        int fromX = 0 - offsetX;
        int fromY = 0 - offsetY;
        int toX = width - offsetX;
        int toY = height - offsetY;


        IntStream.range(0, height).forEach(y ->
            IntStream.range(0, width).forEach(x -> {
                var xid = x - offsetX;
                var yid = y - offsetY;
                System.out.println(x +", "+ y);
                var tileType = tileMap.getTile(yid, xid);



                var tilePanel = Tile.panel(x, y, tileType);
                panel.add(tilePanel);
            })
        );
        System.out.println("----------------------------------");
        
        // Add the character tile at the center of the rendering window
        panel.add(Tile.panel(renderWindowCenterX, renderWindowCenterY, Tile.CHARA), Integer.valueOf(1));

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

interface GameMenuView extends View {

}



interface BattleView extends View {

}

interface DialogueView extends View {

}

