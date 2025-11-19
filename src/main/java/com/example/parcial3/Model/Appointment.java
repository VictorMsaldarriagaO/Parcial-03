package com.example.parcial3.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private Double price;

    public Appointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time, Double price) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Cita [Fecha: %s, Hora: %s, Precio: $%.2f, Paciente: %s, Médico: %s]",
                date,
                time,
                price,
                patient.getName(),
                doctor.getName()
        );
    }
}