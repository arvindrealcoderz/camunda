package com.nt.controller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("registration")
public class CompanyRegistration implements JavaDelegate {

	@Override
	public void execute(DelegateExecution exe) throws Exception {
		String name=(String) exe.getVariable("name");
		System.out.println("Company Name "+name);
	}

}
