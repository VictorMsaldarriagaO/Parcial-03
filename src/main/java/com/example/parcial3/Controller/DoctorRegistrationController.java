package com.example.parcial3.Controller;

import com.example.parcial3.App.HospitalManager;
import com.example.parcial3.Model.Doctor;
import com.example.parcial3.Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DoctorRegistrationController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField IdField;
    @FXML
    private TextField AgeField;
    @FXML
    private TextField genderField;

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void onRegisterButtonClick() {
        String name = nameField.getText().trim();
        String Id = IdField.getText().trim();
        String Age = AgeField.getText().trim();
        String gender = genderField.getText().trim();

        if (name.isEmpty() || Id.isEmpty() || gender.isEmpty() || Age.isEmpty()) {
            showAlert("Error de Validación", "Por favor, complete todos los campos para registrar al médico.");
            return;
        }

        if (!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{2,40}$")) {
            showAlert("Error de Formato", "El campo Nombre debe contener solo letras y espacios, con una longitud de 2 a 40 caracteres.");
            return;
        }

        Integer doctorAge;
        try {
            doctorAge = Integer.parseInt(Age);
            if (doctorAge < 22 || doctorAge > 80) {
                showAlert("Error de Formato", "La Edad debe ser un número positivo y realista (22-80 años).");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error de Formato", "El campo Edad debe ser un número entero válido.");
            return;
        }

        if (!Id.matches("^[0-9]{5,15}$")) {
            showAlert("Error de Formato", "El campo ID/Cédula debe contener solo números, con una longitud de 5 a 15 dígitos.");
            return;
        }

        if (!gender.equalsIgnoreCase("hombre") && !gender.equalsIgnoreCase("mujer")) {
            showAlert("Error de Validación", "El Género debe ser 'hombre' o 'mujer'.");
            return;
        }

        Person newDoctor = new Doctor(Id, name, gender, doctorAge);
        HospitalManager.getInstance().addDoctor((Doctor) newDoctor);

        System.out.println("Nuevo Médico Registrado:\n" + newDoctor.toString());

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Registro Exitoso");
        successAlert.setHeaderText(null);
        successAlert.setContentText("El médico " + name + " ha sido registrado correctamente.");
        successAlert.showAndWait();

        nameField.clear();
        IdField.clear();
        AgeField.clear();
        genderField.clear();
    }
}