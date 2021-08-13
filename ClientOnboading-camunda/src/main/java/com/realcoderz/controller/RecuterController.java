package com.realcoderz.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realcoderz.entity.InterView;
import com.realcoderz.entity.Recuter;
import com.realcoderz.services.IInterviwerService;
import com.realcoderz.services.IRecuterService;
@Controller("RecuterController")
@CrossOrigin("*")
public class RecuterController {

	@Autowired
	private IInterviwerService interviwerservice;
	@Autowired
	private IRecuterService recservice;

	@GetMapping("/getInterviwerName")
	@ResponseBody
	public List<String> getInterviwerName() {
		List<InterView> listInterview=interviwerservice.getAllInterviwer("java", "IT");
		List<String> interviewName=new ArrayList<String>();
		for (int i = 0; i < listInterview.size(); i++) {
			String name=listInterview.get(i).getInterviwerName();
			interviewName.add(name);
		}
		return interviewName;
	}
	
	
	
	
	
	


	
	@GetMapping("/saveRecuter")
	@ResponseBody
	public String saveRecuterDetails() {
		Recuter recuter=new Recuter();

		recuter.setRecuterName("Raja Singh ");
		recuter.setRecruiterEmail("rajav7240@gmail.com");
		recuter.setRecutercategory("IT");
		System.out.println(recservice.saveRecuterDetails(recuter));

		return "Save";
	}
	

}