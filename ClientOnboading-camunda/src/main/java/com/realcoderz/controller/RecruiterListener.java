package com.realcoderz.controller;

import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.entity.InterView;
import com.realcoderz.mail.SendMail;
import com.realcoderz.services.IInterviwerService;
@Controller

public class RecruiterListener implements TaskListener,JavaDelegate{

	private static String recruiterEmail;
	private static String taskId;
	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Integer number =(Integer)execution.getVariable("number");
		String profile =(String)execution.getVariable("profile1");
		Integer percentage =(Integer)execution.getVariable("percentage");
		String interviewer =(String)execution.getVariable("interviewer");
		
		
         
		System.out.println("---RecruiterListener----");
		recruiterEmail =(String)execution.getVariable("recriuterEmail");
		System.out.println("---RecruiterListener----"+recruiterEmail);
		
	}
	
	
	@Override
	public void notify(DelegateTask delegateTask) {
		System.out.println(delegateTask.getId()+"----------------------------------");
		taskId=delegateTask.getId();
			SendMail.sendEmail(delegateTask, recruiterEmail, "interview");
	}
	@GetMapping("/recruitertask")
	@ResponseBody
	public String getTask() {
		System.out.println("recruitertask---"+taskId);
		return taskId;
	}
	
	
}
