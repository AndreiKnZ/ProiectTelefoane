package com.example.proiecttelefoane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);

        stage.setTitle("Telefoane");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        List<Telefon> mobiles = new ArrayList<>();

        mobiles.stream()
                .filter(m -> m.pret > 3000)
                .map(m -> m.name)
                .forEach(System.out::println);
        launch();
    }
}
