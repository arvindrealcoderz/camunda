package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.entity.Client;
import com.nt.service.IClientService;

@Controller("controller")
public class ClientRequirementController implements JavaDelegate{
	@Autowired
	private IClientService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Client client=new Client();
		Client reclient=null;
		String profile=(String) execution.getVariable("profile");
		String percentage=(String) execution.getVariable("percentage");
		
		
	}
	
}
	