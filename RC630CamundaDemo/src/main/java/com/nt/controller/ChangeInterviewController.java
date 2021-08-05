package com.nt.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.entity.Client;
import com.nt.service.IClientService;
@Controller
public class ChangeInterviewController implements JavaDelegate{
	@Autowired
	private IClientService service;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");

	String interviewerName = null;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		interviewerName=(String)execution.getVariable("interviewername");
		String no_of_interviewers=(String)execution.getVariable("no_of_interviewers");
		String clientId=(String) execution.getVariable("clientId");
		Date d=new Date();
		Client cl=new Client();
	}

	@GetMapping(value = "/message",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMessage()
	{
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 3); //same with c.add(Calendar.DAY_OF_MONTH, 1);
		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		String date = dateFormat.format(currentDatePlusOne);

		Client client = new Client();
		client.setDay(date);
		client.setInterviewerName(interviewerName);
		return ResponseEntity.ok(client);
	}

}
