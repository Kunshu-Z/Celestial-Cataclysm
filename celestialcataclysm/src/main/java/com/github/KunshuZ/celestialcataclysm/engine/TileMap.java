package com.github.KunshuZ.celestialcataclysm.engine;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * TileMap class represents the overworld map as a 2D grid of tiles.
 */
public class TileMap {
    List<List<Tile>> tilemap;

    public TileMap(int[][] tilemap) {
        this.tilemap = new ArrayList<>();
        for (int i = 0; i < tilemap.length; i++) {
            this.tilemap.add(new ArrayList<>());
            for (int j = 0; j < tilemap[i].length; j++) {
                this.tilemap.get(i).add(Tile.fromId(tilemap[i][j]));
            }
        }
    }
    public Tile getTile(int y, int x, Tile onDefault) {
        if (y < 0 || y >= tilemap.size() || x < 0 || x >= tilemap.get(y).size()) 
            return onDefault;
        
        return tilemap.get(y).get(x);
    }
    public Tile getTile(int y, int x) {
        if (y < 0 || y >= tilemap.size() || x < 0 || x >= tilemap.get(y).size()) 
            return Tile.BLANK;
        
        return tilemap.get(y).get(x);
    }
    public int height() {
        return tilemap.size();
    }
    public int width() {
        return tilemap.stream()
            .mapToInt(list -> list.size())
            .max()
            .orElse(0);
        }
}
