   package com.realcoderz.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realcoderz.entity.Client;
import com.realcoderz.entity.InterView;
import com.realcoderz.services.IClientService;
import com.realcoderz.services.IInterviwerService;

import oracle.ucp.util.Task;


@Controller("staging1")
public class StagingController implements JavaDelegate {
	public static  int round=1;
	public boolean isInsert=false;
	String profile;
@Autowired
	private  IInterviwerService service;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		 round =(Integer)execution.getVariable("number");//1
		 profile =(String)execution.getVariable("profile1");
		Integer percentage =(Integer)execution.getVariable("percentage");
		String interviewer =(String)execution.getVariable("interviewer");
		
		
		System.out.println("============="+profile);
		Integer noOfInterview=(Integer)execution.getVariable("noOfInterview");
		System.out.println(round+"\t"+noOfInterview);
		if(noOfInterview==1) {
			execution.setVariable("result", 0);
			System.out.println(service.delete(noOfInterview));
			round=1;
		}else {
			round++;
			execution.setVariable("result", 1);
			noOfInterview--;
			execution.setVariable("noOfInterview",noOfInterview);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ClientOnboading","root","root");
			PreparedStatement pst= con.prepareStatement("update job_profile set interviwer_number="+noOfInterview+" where profile='"+profile+"'");
			int count =pst.executeUpdate();
			System.out.println(count);
			
		}
		
		
		System.out.println(round);
		System.out.println("========StagingController=============="+execution.getVariable("noOfInterview"));

		

	} 


	@GetMapping("/round")
	@ResponseBody
	public int getData() {
		return round;
	}


	





	                                                                                                                             
	



}
