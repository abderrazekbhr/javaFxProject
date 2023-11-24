package com.example.javafxproject;

import com.example.javafxproject.model.GameScene;
import com.example.javafxproject.model.StaticThing;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class RunnerMain extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("init() method called");
    }

    public void stop() throws Exception {
        System.out.println("stop() method called");
    }

    @Override
    public void start(Stage stage) throws IOException {
        final int[] sens = {1};
        final double fixedHeight, fixedWidth;

        final int[][] moveArrayHorizantal = {{100, 85}, {100, 170}, {100, 255}, {100, 340}, {100, 0}};
        final int[][] moveUpDown = {{200, 85}, {200, 170}};
        ArrayList<Integer> moveSens = new ArrayList<>();
        moveSens.add(0);
        moveSens.add(0);
        final String backgroundImgUrl = "img/desert.png";
        final String heroImgUrl = "img/heros.png";
        final String heartUrl = "img/heart.png";
        StaticThing heart1 = new StaticThing(32, 32, heartUrl);
        StaticThing heart2 = new StaticThing(32, 32, heartUrl);
        StaticThing heart3 = new StaticThing(32, 32, heartUrl);
        StaticThing backgroundRight = new StaticThing(
            800, 400, backgroundImgUrl);

        StaticThing backgroundMiddle = new StaticThing(
            800, 400, backgroundImgUrl);

        StaticThing backgroundLeft = new StaticThing(
            800, 400, backgroundImgUrl);
        StaticThing heroStatic = new StaticThing(
            0, 0, 80,
            100, heroImgUrl);
        TranslateTransition transitionRight = new TranslateTransition(Duration.millis(10), heroStatic.getImg());
        transitionRight.setByX(5);
        transitionRight.setOnFinished(event -> {
            heroStatic.setPosX(moveArrayHorizantal[moveSens.get(0)][1]);
            moveSens.set(0, (moveSens.get(0) + 1) % 5);
        });
        transitionRight.setInterpolator(Interpolator.EASE_OUT);// Move 300 pixels to the right
        TranslateTransition transitionLeft = new TranslateTransition(Duration.millis(10), heroStatic.getImg());
        transitionLeft.setByX(-10);
        transitionLeft.setOnFinished(event -> {
            heroStatic.setPosX(moveArrayHorizantal[moveSens.get(0)][1]);
            moveSens.set(0, (moveSens.get(0) + 1) % 5);
        });

        TranslateTransition transitionUpAndDown = new TranslateTransition(Duration.millis(600), heroStatic.getImg());
        transitionUpAndDown.setByY(-90);
        transitionUpAndDown.setInterpolator(Interpolator.EASE_BOTH);
        transitionUpAndDown.setOnFinished(e ->
            {
                heroStatic.getImg().setTranslateY(0);
            }
        );
        Pane root = new Pane();
        GridPane hearts = new GridPane();
        hearts.setPadding(new Insets(10, 20, 10, 20));
        hearts.setTranslateY(0);
        hearts.setTranslateX(0);

        GridPane backgrounds = new GridPane();

        //define backgrounds
        backgrounds.add(backgroundRight.getImg(), 0, 0);
        backgrounds.add(backgroundLeft.getImg(), 1, 0);
        backgrounds.add(backgroundMiddle.getImg(), 2, 0);

        //define hearts
        hearts.add(heart1.getImg(), 0, 0);
        hearts.add(heart2.getImg(), 1, 0);
        hearts.add(heart3.getImg(), 2, 0);

        TranslateTransition backgroundTransition = new TranslateTransition(Duration.millis(3000), backgrounds);
        backgroundTransition.setByX(-800);
        backgroundTransition.setCycleCount(Animation.INDEFINITE);
        backgroundTransition.setInterpolator(Interpolator.LINEAR); // Use LINEAR interpolator for constant speed
        backgroundTransition.play();
        backgroundTransition.setOnFinished(event -> {
            backgrounds.getChildren().remove(0);
            backgrounds.add(backgroundLeft.getImg(), 2, 0);
        });

        root.getChildren().add(backgrounds);
        root.getChildren().add(hearts);
        heroStatic.getImg().setX(0);
        heroStatic.getImg().setY(300);
        root.getChildren().add(heroStatic.getImg());
        GameScene scene = new GameScene(root, 800, 400);

        EventHandler<KeyEvent> move = event -> {

            switch (event.getCode()) {
                case RIGHT -> {
                    if (event.isShiftDown()) {
                        transitionUpAndDown.play();
                    } else {
                        if (heroStatic.getImg().getX() < 800 - heroStatic.getSizeX()) {
                            if (sens[0] == -1) {
                                sens[0] = 1;
                                heroStatic.getImg().setScaleX(1);
                            }
                            if (heroStatic.getImg().getTranslateX() < 700) {
                                transitionRight.play();
                            }
                        }
                    }
                }
                case LEFT -> {
                    if (sens[0] == 1) {
                        heroStatic.getImg().setScaleX(-1);
                        sens[0] = -1;
                    }
                    if (heroStatic.getImg().getTranslateX() >10) {
                        transitionLeft.play();
                    }
                }
                case UP -> transitionUpAndDown.play();
            }
            System.out.println(event.getCode());
        };
        scene.addEventHandler(KeyEvent.KEY_PRESSED, move);
        stage.setScene(scene);
        stage.show();
    }

    void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        launch();
    }
}
