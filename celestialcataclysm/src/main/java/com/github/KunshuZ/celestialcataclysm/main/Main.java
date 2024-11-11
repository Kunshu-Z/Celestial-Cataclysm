package com.github.KunshuZ.celestialcataclysm.main;
import com.github.KunshuZ.celestialcataclysm.engine.Window;
import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(CelestialCataclysm::new); //computation in the rendering thread
    }
}
