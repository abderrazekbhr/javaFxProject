package com.example.javafxproject;

import com.example.javafxproject.model.Caracter;
import com.example.javafxproject.model.GameScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.FloatProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.math.BigInteger;
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
        final long baseTime = System.currentTimeMillis();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            long time = System.currentTimeMillis();
            handleMovement(scene, baseTime, time);
            scene.render(); // Ensure scene updates visually after handling movement
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void handleMovement(GameScene scene, final long baseTime, long time) {

        float acceleration = (float) ((time - baseTime) / Math.pow(10, 6));
        scene.getHero().setXHeroAcceleration(acceleration); // Reset acceleration
        scene.render();

    }

    public static void main(String[] args) {
        launch();
    }
}
