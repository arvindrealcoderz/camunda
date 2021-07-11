package com.nt.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Patient;
import com.nt.service.IPatientService;

@Component("login")
public class PatientLogin implements JavaDelegate {
	
	@Autowired
	private IPatientService service;
	public void execute(DelegateExecution execution) throws Exception {
		
		String name=((String)execution.getVariable("name"));
		String mobile=((String)execution.getVariable("mobile"));
		Patient patient=new Patient();
		patient.setMobile(mobile);
		patient.setPname(name);
		execution.setVariable("logresult",service.login(patient));
	}

}
