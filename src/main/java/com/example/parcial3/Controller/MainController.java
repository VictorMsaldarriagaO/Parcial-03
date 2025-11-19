package com.example.parcial3.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane Main;

    @FXML
    protected void showPatientRegistration(ActionEvent event) {
        cargarVista("/com/example/parcial3/PacientRegistration.fxml");
    }

    @FXML
    protected void showDoctorRegistration(ActionEvent event) {
        cargarVista("/com/example/parcial3/DoctorRegistration.fxml");
    }

    @FXML
    protected void showAppointmentRegistration(ActionEvent event) {
        cargarVista("/com/example/parcial3/AppointmentRegistration.fxml");
    }

    @FXML
    protected void onSalir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    private void cargarVista(String fxmlFile) {
        try {
            java.net.URL fxmlUrl = getClass().getResource(fxmlFile);

            if (fxmlUrl == null) {
                System.err.println("ERROR: El archivo FXML no se encontró. Revise la ruta: " + fxmlFile);
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            javafx.scene.Node vista = loader.load();

            Main.setCenter(vista);

        } catch (IOException e) {
            System.err.println("ERROR: No se pudo cargar la vista FXML.");
            System.err.println("Ruta intentada: " + fxmlFile);
            e.printStackTrace();
        }
    }
}