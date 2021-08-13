package com.realcoderz.controller;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realcoderz.entity.Client;
import com.realcoderz.mail.SendMail;
import com.realcoderz.services.ISuperAdminService;
@Controller
public class SuperAdminController implements JavaDelegate ,TaskListener{
	
	@Autowired
	private ISuperAdminService adminservice;
	
	private static String email=null;
	private static String clientname=null;
	private static String license=null;
	private static Integer superAdminId=null;
	private static String description=null;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
			email=(String)execution.getVariable("client-email");
			clientname=(String)execution.getVariable("client-name");
			license=(String)execution.getVariable("client-license");
			description=(String)execution.getVariable("description");

			System.out.println(execution.getId()+"-------------------SuperAdminController---------------");
			Client client=new Client();

			client.setName(clientname);
			client.setEmail(email);
			client.setDescription(description);
			client.setLicence(license);
			
			//save the recored 
			if(email!=null && clientname!=null) {
				superAdminId =adminservice.saveRecored(client);
				SendMail.sendEmail(execution, email, "jobprofile");
			}
			
			if(superAdminId!=null) {
				execution.setVariable("adminId", superAdminId);
				execution.setVariable("clientemail", email);
				//SendMail.sendEmail(execution, email, "jobprofile");
			}
			
			String result=superAdminId!=null?"Your recored has been saved with the id :: "+superAdminId:"Your recored has been not saved please try again..";
			System.out.println(result);
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		SendMail.sendEmail(delegateTask, email, "jobprofile");
		
		
	}
	
	
	
	
	@GetMapping("/getAllClient")
	@ResponseBody
	public List<Client> getAllClient(){
		 adminservice.getAllClient().forEach(System.out::println)
;		return adminservice.getAllClient();
		
	}

}