package com.nt.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Patient;
import com.nt.service.IPatientService;

@Component("retrive")
public class PatientDetails implements JavaDelegate {
	
	@Autowired
	private IPatientService service;
	public void execute(DelegateExecution execution) throws Exception {
		List<Patient> list=	service.fetchPatient();
		for (Patient patient : list) {
			System.out.println(patient.getPname());
		}
		System.out.println("PatientDetails.execute()"+list.get(0).getPname());
		execution.setVariable("emp", list.get(0).getPname());
	}

}
