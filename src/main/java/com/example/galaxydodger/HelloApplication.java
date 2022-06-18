package com.example.galaxydodger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.ViewManager;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewManager manager = new ViewManager();
        stage = manager.getMainStage();
        stage.setTitle("Galaxy Dodger");
        stage.getIcons().add(new Image("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerShip3_blue.png"));
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}