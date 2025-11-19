package com.example.parcial3.Controller;

import com.example.parcial3.App.HospitalManager;
import com.example.parcial3.Model.Patient;
import com.example.parcial3.Model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
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
            showAlert(Alert.AlertType.ERROR, "Error de Validación", "Por favor, complete todos los campos.");
            return;
        }

        if (!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{2,40}$")) {
            showAlert(Alert.AlertType.ERROR, "Error de Formato", "El campo Nombre debe contener solo letras y espacios, con una longitud de 2 a 40 caracteres.");
            return;
        }

        Integer patientAge;
        try {
            patientAge = Integer.parseInt(Age);
            if (patientAge <= 0 || patientAge > 120) {
                showAlert(Alert.AlertType.ERROR, "Error de Formato", "La Edad debe ser un número positivo y realista (1-120 años).");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error de Formato", "El campo Edad debe ser un número entero válido.");
            return;
        }

        if (!Id.matches("^[0-9]{5,15}$")) {
            showAlert(Alert.AlertType.ERROR, "Error de Formato", "El campo ID/Cédula debe contener solo números, con una longitud de 5 a 15 dígitos.");
            return;
        }

        if (!gender.equalsIgnoreCase("hombre") && !gender.equalsIgnoreCase("mujer")) {
            showAlert(Alert.AlertType.ERROR, "Error de Validación", "El Género debe ser 'hombre' o 'mujer'.");
            return;
        }

        Person newPacient = new Patient(Id, name, gender, patientAge);
        HospitalManager.getInstance().addPatient((Patient) newPacient);

        System.out.println("Nuevo Paciente Registrado:\n" + newPacient.toString());

        showAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", "El paciente " + name + " ha sido registrado correctamente.");

        nameField.clear();
        IdField.clear();
        AgeField.clear();
        genderField.clear();
    }
}