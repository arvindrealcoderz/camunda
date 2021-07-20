package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.dao.IPatientDao;
import com.nt.entity.Patient;

@Component("servie")
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientDao dao;
	@Override
	public int login(Patient patient) {
		return dao.login(patient);
	}
	@Override
	public int patientRegistration(Patient patient) {
		return dao.patientRegistration(patient);
	}
	@Override
	public List<Patient> fetchPatient() {
		return dao.fetchPatient();
	}

}
