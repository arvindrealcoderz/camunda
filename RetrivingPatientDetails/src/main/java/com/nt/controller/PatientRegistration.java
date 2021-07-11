package com.nt.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Patient;
import com.nt.service.IPatientService;

@Component("reg")
public class PatientRegistration implements JavaDelegate {
	@Autowired
	private IPatientService service;
	public void execute(DelegateExecution execution) throws Exception {

		String name=((String)execution.getVariable("name"));
		String addr=((String)execution.getVariable("addr"));
		String age=((String)execution.getVariable("age"));
		String mobile=((String)execution.getVariable("mobile"));
		//create patient object
		Patient pat=new Patient();
		pat.setPname(name);
		pat.setPaddr(addr);
		pat.setMobile(mobile);
		pat.setPage(age);

		String result=service.patientRegistration(pat)!=0?"registration Success":"registration failue";
		execution.setVariable("result",result);
	}

}
