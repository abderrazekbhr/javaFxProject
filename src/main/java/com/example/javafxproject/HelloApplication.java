package com.example.javafxproject;

import com.example.javafxproject.model.GameScene;
import com.example.javafxproject.model.StaticThing;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("init() method called");
    }

    public void stop() throws Exception {
        System.out.println("stop() method called");
    }

    @Override
    public void start(Stage stage) throws IOException {
        final double fixedHeight, fixedWidth;
        final String backgroundImg = "img/desert.png";
        final String heroImg = "img/heros.png";
        StaticThing backgroundStatic = new StaticThing(
            640, 300, backgroundImg);
        StaticThing heroStatic = new StaticThing(
            20, 20, heroImg);

        Pane root = new Pane();
        root.getChildren().add(backgroundStatic.getImg());
        root.getChildren().add(heroStatic.getImg());
        GameScene scene = new GameScene(root);
        EventHandler<MouseEvent> event = event1 ->
        {
            scene.render((int) Math.random(),(int) Math.random());
        };
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setTitle("Hello!");*/


    }

    void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        launch();
    }
}
