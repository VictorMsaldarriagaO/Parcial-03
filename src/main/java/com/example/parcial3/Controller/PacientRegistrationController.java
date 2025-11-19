package com.example.parcial3.Controller;

import com.example.parcial3.Model.Patient;
import com.example.parcial3.Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PacientRegistrationController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField IdField;
    @FXML
    private TextField AgeField;
    @FXML
    private TextField genderField;
    @FXML
    private Label welcomeText;


    private void showAlert(String title, String content) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    @FXML
    protected void onRegisterButtonClick() {
        String name = nameField.getText().trim();
        String Id = IdField.getText().trim();
        String Age = AgeField.getText().trim();
        String gender = genderField.getText().trim();

        if (name.isEmpty() || Id.isEmpty() || gender.isEmpty() || Age.isEmpty()) {
            showAlert("Error de Validación", "Por favor, complete todos los campos.");
            return;
        }

        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
            showAlert("Error de Formato", "El campo Nombre solo debe contener letras.");
            return;
        }

        Integer patientAge;
        try {
            patientAge = Integer.parseInt(Age);
            if (patientAge <= 0 || patientAge > 120) {
                showAlert("Error de Formato", "La Edad debe ser un número positivo y realista.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error de Formato", "El campo Edad debe ser un número entero válido.");
            return; // <-- Cierre del try-catch
        }

        if (!Id.matches("[a-zA-Z0-9\\s]+")) {
            showAlert("Error de Formato", "El campo ID/Cédula solo debe contener letras y números.");
            return;
        }

        if (!gender.equalsIgnoreCase("hombre") && !gender.equalsIgnoreCase("mujer")) {
            showAlert("Error de Validación", "El Género debe ser 'hombre' o 'mujer'.");
            return;
        }

        Person newPacient = new Patient(Id, name, gender, patientAge);

        System.out.println("Nuevo Paciente Registrado:");
        System.out.println(newPacient.toString());

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Registro Exitoso");
        successAlert.setHeaderText(null);
        successAlert.setContentText("El paciente " + name + " ha sido registrado correctamente.");
        successAlert.showAndWait();

        nameField.clear();
        IdField.clear();
        AgeField.clear();
        genderField.clear();
    }
}