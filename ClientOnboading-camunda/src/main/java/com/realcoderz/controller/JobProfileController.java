package com.realcoderz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realcoderz.entity.JobProfile;
import com.realcoderz.entity.Recuter;
import com.realcoderz.services.IJobProfileService;
import com.realcoderz.services.IRecuterService;

@Controller("jobprofilecontroller")
@CrossOrigin("*")
public class JobProfileController {
	
	@Autowired
	private IJobProfileService service;

	@Autowired
	private IRecuterService recservice;
	//--------------------select reciter name--------------------
	@GetMapping("/profileSelect")
	@ResponseBody
	public List<String> getAllEmployee(String profile) {
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
	//---------------------save job profile---------------------

	@PostMapping("/saveAllJobProfile")
	public String saveAllJobProfile(@ModelAttribute JobProfile profile){
		String pro=profile.getRecuterName();

		System.out.println(pro+"--------------------------------");





		return service.save(profile)!=null?"recoreed save":"recored not save";
	}
	//----------getting all job profile-----

	//profile and recuter

	@GetMapping("/getAllJobProfile")
	@ResponseBody
	public List<JobProfile> getAllJobProfile(){

		return service.getAllClient();
	}	
}
