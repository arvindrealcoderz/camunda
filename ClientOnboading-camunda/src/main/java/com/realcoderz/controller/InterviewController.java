package com.realcoderz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.entity.InterView;
import com.realcoderz.services.IInterviwerService;

@RestController("interviewController")
@CrossOrigin("*")
public class InterviewController {

    @Autowired
	private IInterviwerService service;
	String name;
	String email;
	String profile;
	Integer experience;


	@PostMapping("/interviewSaveData")
	@ResponseBody
	public String saveData(@RequestBody InterView interview ) {
		    System.out.println("inside interviewSaveData"+interview.getProfile());
			System.out.println(service.saveInterviewerDeatils(interview));

		return service.saveInterviewerDeatils(interview);


	}
	
	@GetMapping("/getInterviewerProfileBased")
	@ResponseBody
	public List<String> getSelectedRecruiter(String category) {
		List<String> list=new ArrayList<String>();
		list.forEach(System.out::println);
			List<InterView> listRecuter =service.getAllInterviwerProfileBased(category);
			for (int i = 0; i < listRecuter.size(); i++) {
				list.add(listRecuter.get(i).getInterviwerName());
			}
			
		
		return list;
		
	}
	
	
	
	@GetMapping("/getInterviwerList")
	@ResponseBody
	public List<InterView>  getInterviwerList() {
		return service.getAllInterviwerDetails();

	}

}
