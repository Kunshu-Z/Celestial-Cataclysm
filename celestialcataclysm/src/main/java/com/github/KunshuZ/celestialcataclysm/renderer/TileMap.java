package com.github.KunshuZ.celestialcataclysm.renderer;
import java.util.List;
import java.util.ArrayList;

public class TileMap {
    List<List<TileType>> tilemap;

    public TileMap(int[][] tilemap) {
        this.tilemap = new ArrayList<>();
        for (int i = 0; i < tilemap.length; i++) {
            this.tilemap.add(new ArrayList<>());
            for (int j = 0; j < tilemap[i].length; j++) {
                this.tilemap.get(i).add(TileType.values()[tilemap[i][j]]);
            }
        }
    }
    public TileType getTile(int y, int x) {
        return tilemap.get(y).get(x);
    }
}
