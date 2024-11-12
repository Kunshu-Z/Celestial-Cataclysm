package com.github.KunshuZ.celestialcataclysm.main;
import javax.swing.*;

import com.github.KunshuZ.celestialcataclysm.engine.CelestialCataclysm;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(CelestialCataclysm::new);
    }
}
