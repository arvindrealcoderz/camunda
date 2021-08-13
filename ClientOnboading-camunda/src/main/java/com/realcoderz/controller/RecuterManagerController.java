package com.realcoderz.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.entity.JobProfile;
import com.realcoderz.entity.Recuter;
import com.realcoderz.mail.SendMail;
import com.realcoderz.services.IInterviwerService;
import com.realcoderz.services.IJobProfileService;
import com.realcoderz.services.IRecuterManagerService;
import com.realcoderz.services.IRecuterService;

@RestController("RecuterManagerController")
@CrossOrigin("*")
public class RecuterManagerController implements JavaDelegate,TaskListener {

	@Autowired
	private IRecuterManagerService recuterManagerservice;
	@Autowired
	private IRecuterService recuterservice;

	@Autowired
	private IJobProfileService service;

	@Autowired
	private IRecuterService recservice;
	@Autowired
	private IInterviwerService interviwerservice;
	
	
	public Integer interviwerNumber;
	public Integer assigned;
	public String profile1;
	public String category;
	public String recuterName;
	public static String clientemail;
	public static String check;
	public static Integer adminId;
	public static String taskId;
	public String email;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		profile1=		(String)execution.getVariable("profile");
		category=		(String)execution.getVariable("category");
		recuterName= (String)execution.getVariable("recruiter");
		interviwerNumber=		(Integer)execution.getVariable("noOfInterview");
		adminId=		(Integer)execution.getVariable("adminId");
		clientemail= (String)execution.getVariable("clientemail");
		
		
		
		
		List<Recuter> list= recservice.getRecuterByName(recuterName);
		for (int i = 0; i < list.size(); i++) {
			email=list.get(i).getRecruiterEmail();
		}
		
		execution.setVariable("recriuterEmail", email);
		//---------pendiong

		adminId=(Integer)execution.getVariable("adminId");
		clientemail= (String)execution.getVariable("clientemail");
		System.out.println("-email---"+email);
		System.out.println("-recuterName---"+recuterName);
		
		
		System.out.println(assigned);
		System.out.println(category);
		System.out.println(interviwerNumber);
		System.out.println(profile1);
		System.out.println(recuterName);
		
		JobProfile profile=new JobProfile();
		//profile.setAssigned(assigned);
		profile.setCategory(category);
		profile.setInterviwerNumber(interviwerNumber);
		profile.setProfile(profile1);
		profile.setRecuterName(recuterName);
		
		System.out.println(service.save(profile)!=null?"recoreed save":"recored not save");
		//-----------------------arvind verma---12-08--------
		if(email==null)
			SendMail.sendEmail(execution, "arvind7238realcoderz@gmail.com", "Interview");
		else
			SendMail.sendEmail(execution, email, "Interview");
	}

	
	
	
	@GetMapping("/getRecruiter")
	@ResponseBody
	public List<String> getSelectedRecruiter(String profile) {
		List<String> list=new ArrayList<String>();

		if(profile.equalsIgnoreCase("java")||profile.equalsIgnoreCase("php")||profile.equalsIgnoreCase("python")) {
			List<Recuter> listRecuter =recservice.getAllRecuter("IT");
			for (int i = 0; i < listRecuter.size(); i++) {
				list.add(listRecuter.get(i).getRecuterName());
			}
			return list;
		}
		else if(profile.equalsIgnoreCase("sales")) {
			List<Recuter> listRecuter =recservice.getAllRecuter("sales");
			for (int i = 0; i < listRecuter.size(); i++) {
				list.add(listRecuter.get(i).getRecuterName());
			}
			return list;
		}
		else {
			List<Recuter> listRecuter =recservice.getAllRecuter("account");
			for (int i = 0; i < listRecuter.size(); i++) {
				list.add(listRecuter.get(i).getRecuterName());
			}
			return list;
		}

	}
	
	
	
	
	
	
	
	
	@GetMapping("/task")
	public String getTaskId() {
		System.out.println("inside controller"+taskId);
		return taskId;
	}
	
	
	
	@Override
	public void notify(DelegateTask delegateTask) {
		taskId=delegateTask.getId();
		System.out.println("listener"+taskId);
		
		
	}
		
	
	@GetMapping("/getAllrecruiter")
	@ResponseBody
	public List<Recuter> getAllrecruiter(){
		return recservice.getAllRecuter();
	}
	
	
	//-----------------------------------------count job profile------------------------
	
	Map<String, Long> map=new HashMap<String, Long>();
	@GetMapping("/countDetails")
	@ResponseBody
	public Map<String, Long> countDetails(){

		long profileCount=service.countJobProfile();
		long recruiterCount=recservice.countRecruiter();
		long interviewerCount=interviwerservice.countInterviewer();
		long total=profileCount+recruiterCount+interviewerCount;
		System.out.println("RecuterManagerController.run()");

		map.put("profileCount", profileCount);
		map.put("recruiterCount", recruiterCount);
		map.put("interviewerCount", interviewerCount);
		map.put("total", total);
		System.out.println(profileCount+"\t"+recruiterCount+"\t"+interviewerCount+"\t"+total);
		return map;
		
	}
	
	
	

}