package com.realcoderz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.RecuterManager;
import com.realcoderz.repository.IRecuterManagerRepo;
@Service("recutermanager")
public class RecuterManagerServiceImpl implements IRecuterManagerService {

	@Autowired
	private IRecuterManagerRepo service;
	
	
	@Override
	public String saveRecuterDetails(RecuterManager recutermanager) {
		System.out.println("RecuterManagerServiceImpl.saveRecuterDetails()");
		RecuterManager recuterManager=service.save(recutermanager);
		String result=recuterManager!=null?"Your recored has been saved with the id recutermanager:: "+recuterManager.getRecuterManagerId():"Your recored has been not saved please try again..";
		return result;
	}
	@Override
	public List<RecuterManager> getAllRecuterManager() {
		return service.getAllClient();
	}
	

	

}
