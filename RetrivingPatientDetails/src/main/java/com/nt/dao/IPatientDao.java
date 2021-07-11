package com.nt.dao;

import java.util.List;

import com.nt.entity.Patient;

public interface IPatientDao {
	public int login(Patient patient);
	public int patientRegistration(Patient patient);
	public List<Patient> fetchPatient();
}

