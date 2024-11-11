package com.github.KunshuZ.celestialcataclysm.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import java.nio.file.Path;



public class Assets {
    /**
     * get absolute path of project
     */
    public static Path getAbsolutePath() {
        return Paths.get("").toAbsolutePath();
    }

    /**
     * get absolute path of resource folder
     */
    public static Path getResourcePath() {
        return getAbsolutePath().resolve("celestialcataclysm/src/main/resources");
    }

    /**
     * get resource
     */
    public static URL getResource(String path) {
        return Assets.class.getResource(path);
    }

}
