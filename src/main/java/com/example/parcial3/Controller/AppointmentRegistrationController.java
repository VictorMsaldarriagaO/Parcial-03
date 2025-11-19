package com.example.parcial3.Controller;

import com.example.parcial3.App.HospitalManager;
import com.example.parcial3.Model.Appointment;
import com.example.parcial3.Model.Doctor;
import com.example.parcial3.Model.Patient;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class AppointmentRegistrationController {

    @FXML
    private ComboBox<Patient> patientComboBox;
    @FXML
    private ComboBox<Doctor> doctorComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField timeField;
    @FXML
    private TextField priceField;
    @FXML
    private ListView<Appointment> appointmentListView;

    private HospitalManager manager = HospitalManager.getInstance();

    @FXML
    public void initialize() {
        patientComboBox.setItems(FXCollections.observableArrayList(manager.getPatients()));
        doctorComboBox.setItems(FXCollections.observableArrayList(manager.getDoctors()));

        patientComboBox.setConverter(new PatientNameStringConverter());
        doctorComboBox.setConverter(new DoctorNameStringConverter());

        appointmentListView.setItems(FXCollections.observableArrayList(manager.getAppointments()));
    }

    @FXML
    protected void onRegisterAppointmentClick() {
        Patient selectedPatient = patientComboBox.getSelectionModel().getSelectedItem();
        Doctor selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();
        LocalDate selectedDate = datePicker.getValue();
        String timeText = timeField.getText().trim();
        String priceText = priceField.getText().trim();

        if (selectedPatient == null || selectedDoctor == null || selectedDate == null || timeText.isEmpty() || priceText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Validación", "Por favor, complete todos los campos y seleccione paciente/médico.");
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeText);
        } catch (DateTimeParseException e) {
            showAlert(Alert.AlertType.ERROR, "Error de Formato", "El formato de la hora es incorrecto. Use HH:MM (ej: 14:30).");
            return;
        }

        Double price;
        try {
            price = Double.parseDouble(priceText);
            if (price <= 0) {
                showAlert(Alert.AlertType.ERROR, "Error de Formato", "El precio debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error de Formato", "El campo Precio debe ser un número válido.");
            return;
        }

        Appointment newAppointment = new Appointment(selectedPatient, selectedDoctor, selectedDate, time, price);
        manager.addAppointment(newAppointment);

        appointmentListView.getItems().add(newAppointment);
        clearFields();

        showAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", "La cita ha sido registrada correctamente.");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFields() {
        patientComboBox.getSelectionModel().clearSelection();
        doctorComboBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        timeField.clear();
        priceField.clear();
    }
}