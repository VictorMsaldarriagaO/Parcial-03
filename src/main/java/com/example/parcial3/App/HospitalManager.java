package com.example.parcial3.App;

import com.example.parcial3.Model.Appointment;
import com.example.parcial3.Model.Doctor;
import com.example.parcial3.Model.Patient;

import java.util.ArrayList;
import java.util.List;

public class HospitalManager {
    private static HospitalManager instance;

    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Appointment> appointments;

    private HospitalManager() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        loadInitialData();
    }

    public static HospitalManager getInstance() {
        if (instance == null) {
            instance = new HospitalManager();
        }
        return instance;
    }

    private void loadInitialData() {
        // Médicos de ejemplo
        doctors.add(new Doctor("1111", "Dr. Sofia Rodriguez", "mujer", 35));
        doctors.add(new Doctor("2222", "Dr. Carlos Mesa", "hombre", 42));

        // Pacientes de ejemplo
        patients.add(new Patient("3333", "Laura Gonzalez", "mujer", 28));
        patients.add(new Patient("4444", "Pedro Ramirez", "hombre", 55));
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}