package com.github.KunshuZ.celestialcataclysm.engine;

interface Model{
    
}

public interface Scene {
    Controller controller();
    Model model();
    View view();
    
}
