package com.nt.service;

import java.util.List;

import com.nt.entity.Patient;

public interface IPatientService {
	public int login(Patient patient);
	public int patientRegistration(Patient patient);
	public List<Patient> fetchPatient();

}
