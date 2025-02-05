package com.example.javafxproject.model;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameScene extends Scene {
    public static final String IMG_PATH = "src/main/resources/com/example/javafxproject/assets/";
    public static final double WIDTH = 1000;
    public static final double HEIGHT = 500;
    public static final double POS_INIT = 400;
    public final Group group = new Group();
    private Camera cameraScene = new Camera();
    private StaticThing leftBackground;
    private StaticThing middleBackground;
    private StaticThing rightBackground;
    private Caracter hero;
    // private Audio backgroundAudio;
    private Audio jump;
    private boolean isDel = true;
    private Audio steps;
    private int nbElement = 4;
    private double distance = 600;

    public GameScene(Parent root) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, WIDTH, HEIGHT);
        root.maxWidth(WIDTH);
        root.maxHeight(HEIGHT);
        final String IMG = "img/";
        final String backgroundImg = IMG + "desert2.png";
        final String heroImg = IMG + "heros.png";
        leftBackground = new StaticThing(backgroundImg);
        middleBackground = new StaticThing(backgroundImg);
        rightBackground = new StaticThing(backgroundImg);
        leftBackground.setPosY(-300);
        middleBackground.setPosY(-300);
        rightBackground.setPosY(-300);
        leftBackground.setPosX(0);
        middleBackground.setPosX(1600);
        rightBackground.setPosX(3200);
        // backgroundAudio = new Audio("Mars.wav");
        /*
         * jump = new Audio("jump.wav");
         * steps = new Audio("run.wav");
         */

        hero = new Caracter(
                20, 0, 65, 100, heroImg);
        group.maxWidth(WIDTH);
        group.maxHeight(HEIGHT);
        group.getChildren().add(leftBackground.getImg());
        group.getChildren().add(middleBackground.getImg());
        group.getChildren().add(rightBackground.getImg());
        group.getChildren().add(hero.getImg());
        setRoot(group);
    }

    public GameScene(Parent root, double width, double height)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, width, height);
    }

    public GameScene(Parent root, Paint fill)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, fill);
    }

    public GameScene(Parent root, double width, double height, Paint fill)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, width, height, fill);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, width, height, depthBuffer);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(root, width, height, depthBuffer, antiAliasing);
    }

    public StaticThing getLeftBackground() {
        return leftBackground;
    }

    public StaticThing getMiddleBackground() {
        return middleBackground;
    }

    public StaticThing getRightBackground() {
        return rightBackground;
    }

    public Caracter getHero() {
        return hero;
    }

    public Audio getJump() {
        return jump;
    }

    public Audio getSteps() {
        return steps;
    }

    public void render() {
        hero.update();

        cameraScene.update(
                hero.getXHeroSpeed(),
                hero.getXHeroPosition(),
                hero.getYHeroAcceleration(),
                hero.getYHeroPosition());
        hero.transition(cameraScene.getCamXPosition(), cameraScene.getCamYPosition());

        final double WIDTH_BG = 1600;
        if (leftBackground.getPosX() - cameraScene.getCamXPosition() < -WIDTH_BG) {
            leftBackground.setPosX(leftBackground.getPosX() + (2 * WIDTH_BG));
        }
        if (leftBackground.getPosX() - cameraScene.getCamXPosition() > WIDTH_BG) {
            leftBackground.setPosX(leftBackground.getPosX() - 2 * WIDTH_BG);
        }
        if (middleBackground.getPosX() - cameraScene.getCamXPosition() < -WIDTH_BG) {
            middleBackground.setPosX(middleBackground.getPosX() + (2 * WIDTH_BG));
        }
        if (middleBackground.getPosX() - cameraScene.getCamXPosition() > (WIDTH_BG)) {
            middleBackground.setPosX(middleBackground.getPosX() - (2 * WIDTH_BG));
        }
        if (rightBackground.getPosX() - cameraScene.getCamXPosition() < -(WIDTH_BG)) {
            rightBackground.setPosX(rightBackground.getPosX() + (2 * WIDTH_BG));
        }
        if (rightBackground.getPosX() - cameraScene.getCamXPosition() > (WIDTH_BG)) {
            rightBackground.setPosX(rightBackground.getPosX() - (2 * WIDTH_BG));
        }

        leftBackground.getImg().setY(
                leftBackground.getPosY() - cameraScene.getCamYPosition());
        leftBackground.getImg().setX(leftBackground.getPosX() - cameraScene.getCamXPosition());
        middleBackground.getImg().setX(middleBackground.getPosX() - cameraScene.getCamXPosition());
        middleBackground.getImg().setY(middleBackground.getPosY() - cameraScene.getCamYPosition());
        rightBackground.getImg().setX(rightBackground.getPosX() - cameraScene.getCamXPosition());
        rightBackground.getImg().setY(rightBackground.getPosY() - cameraScene.getCamYPosition());
        if (hero.getXHeroSpeed() > 0) {
            distance += 400;
            if (isDel) {
                group.getChildren().add(new Obstacle((int) distance + 100).getImg());
                isDel = false;
            }
            if (distance - cameraScene.getCamXPosition() - 200 < 0) {
                isDel = true;
                if (nbElement == 5) {
                    group.getChildren().remove(4);
                }
            } else {
                isDel = false;
            }

        }

        hero.setXHeroAcceleration(0);
        hero.setYHeroAcceleration(0);

    }

    public Camera getCameraScene() {
        return cameraScene;
    }
}
