package com.github.KunshuZ.celestialcataclysm.utils;

import java.io.File;
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
     * get file from path in resource folder
     */
    public static File getFile(Path path) {
        return new File(getResourcePath().resolve(path).toString());
    }

    /**
     * get image from path in resource folder
     */
    public static ImageIcon getImage(Path path) {
        var file = getFile(path);
        return new ImageIcon(file.toString());
    }
}
