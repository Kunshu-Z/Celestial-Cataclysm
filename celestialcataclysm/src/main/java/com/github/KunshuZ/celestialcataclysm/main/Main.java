package com.github.KunshuZ.celestialcataclysm.main;
import javax.swing.*;
import java.awt.*;
import com.github.KunshuZ.celestialcataclysm.renderer.Window;


public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(CelestialCataclysm::new); //run/compute Window.display() on the rendering thread 
    }
}
