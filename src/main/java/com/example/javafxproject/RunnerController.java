package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RunnerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
