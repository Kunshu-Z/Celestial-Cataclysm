package com.github.KunshuZ.celestialcataclysm.engine;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Arrays;

/**
 * An object that represents the main window of the game by being a JFrame.
 * What is being rendered on the window is determined by the current scene.
 */
public class Window extends JFrame{
    public static final int width = ((5*3)+1)*48;
    public static final int height = ((5*3)+1)*48;
    private Stack<Scene> scenes = new Stack<>();
    private Scene currentScene;

    public Window(String title){
        super();
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(height, width);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setScene(Stack<Scene> scenes){
        this.scenes = scenes;
        this.currentScene = scenes.peek();
        var view = currentScene.view();
        this.add(view.panel());
        view.render();
        view.panel().setFocusable(true);
    }

    public void setScene(Scene scene) {
        this.currentScene = scene;
        getContentPane().removeAll();
        JComponent panel = scene.view().panel();
        getContentPane().add(panel);
        revalidate();
        repaint();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }



    public void ping(){


        if(currentScene != scenes.peek()){
            
            currentScene = scenes.peek();
            this.setScene(currentScene);
        }
        this.revalidate();

        this.repaint();
        currentScene.view().render();
        currentScene.view().panel().setFocusable(true);
    }
}

/**
 * A stack of scenes/game states
 * The top of the stack is the current scene
 * 
 */
class SceneManager extends Stack<Scene> {
    public Stack<Scene> stateStack = new Stack<>();
    Scene currentScene = EmptyScene.INSTANCE;

    public SceneManager(Scene scene, Scene... scenes){
        List<Scene> sceneList = Arrays.asList(scenes);
        Collections.reverse(sceneList);
        for (Scene s : sceneList)
            this.push(s);
        this.currentScene = scene;
        this.push(scene);
    }
    
    public Scene push(Scene scene){
        stateStack.push(scene);
        currentScene = stateStack.peek();
        return scene;
    }
    public Scene pop(){
        if(stateStack.isEmpty()) return EmptyScene.INSTANCE;
        currentScene = stateStack.peek();
        return stateStack.pop();
    }
    public Scene peek(){
        if(stateStack.isEmpty()) return EmptyScene.INSTANCE;
        var top = stateStack.peek();
        return top;
    }
    public void remove(Scene scene){
        stateStack.remove(scene);
    }

    public Scene get(){
        return currentScene;
    }

    public void ping(){
        currentScene.ping();
    }

    public void render(){
        currentScene.view().render();
    }

    public void clear(){
        stateStack.clear();
    }
}
