package com.example.parcial3.Controller;

import com.example.parcial3.Model.Doctor;
import javafx.util.StringConverter;

public class DoctorNameStringConverter extends StringConverter<Doctor> {
    @Override
    public String toString(Doctor doctor) {
        return (doctor != null) ? doctor.getName() : "";
    }

    @Override
    public Doctor fromString(String string) {
        return null;
    }
}