package org.example.temperatureconverter.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.temperatureconverter.panes.RootPane;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var root = new RootPane();
        Scene scene = new Scene(root, 400, 400);

        Image icon = new Image("temperatures.png");
        stage.getIcons().add(icon);

        String css = this.getClass().getResource("/org/example/temperatureconverter/styles/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Temperature Converter");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
