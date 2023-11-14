package com.example.javafxproject.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameScene extends Scene {
    Camera camera;
    Integer numberOfLives = 3;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;


    public GameScene(Parent root) {
        super(root);
        this.camera = new Camera();
    }

    public GameScene(Parent root, double width, double height) {
        super(root, width, height);
    }

    public GameScene(Parent root, Paint fill) {
        super(root, fill);
    }

    public GameScene(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }


    public void render(int x, int y) {
        camera.setX(camera.x - x);
        camera.setY(camera.y - y);
    }

    public static void main(String[] args) {

    }

}
