package com.example.parcial3.Controller;

import com.example.parcial3.Model.Patient;
import javafx.util.StringConverter;

public class PatientNameStringConverter extends StringConverter<Patient> {
    @Override
    public String toString(Patient patient) {
        return (patient != null) ? patient.getName() : "";
    }

    @Override
    public Patient fromString(String string) {
        return null;
    }
}
