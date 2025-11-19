package com.example.parcial3.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/parcial3/menu-view.fxml")
        );

        if (fxmlLoader.getLocation() == null) {
            System.err.println("¡ERROR! No se pudo encontrar el archivo FXML.");
            throw new IOException("FXML no encontrado. Revise la ruta y la estructura del proyecto.");
        }

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Bienvenido");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}