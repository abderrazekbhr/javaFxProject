package com.example.javafxproject;

import com.example.javafxproject.model.Caracter;
import com.example.javafxproject.model.GameScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class RunnerMain extends Application {

    private final Set<KeyCode> activeKeys = new HashSet<>();

    @Override
    public void init() throws Exception {
        System.out.println("init() method called");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() method called");
    }

    @Override
    public void start(Stage stage) {
        try {
            Group group = new Group();
            GameScene scene = new GameScene(group);

            // Handle key press and release events
            scene.setOnKeyPressed(event -> activeKeys.add(event.getCode()));
            scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode()));

            stage.setTitle("Runner Game");
            stage.setScene(scene);
            stage.show();

            startAnimation(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startAnimation(GameScene scene) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            handleMovement(scene);
            scene.render(); // Ensure scene updates visually after handling movement
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void handleMovement(GameScene scene) {
        if (activeKeys.contains(KeyCode.LEFT)) {
            System.out.println("LEFT key pressed");
            scene.getHero().update();
        }
        if (activeKeys.contains(KeyCode.RIGHT)) {
            System.out.println("RIGHT key pressed");
        }
        if (activeKeys.contains(KeyCode.UP)) {
            System.out.println("UP key pressed");
        }
        if (activeKeys.contains(KeyCode.DOWN)) {
            System.out.println("DOWN key pressed");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
