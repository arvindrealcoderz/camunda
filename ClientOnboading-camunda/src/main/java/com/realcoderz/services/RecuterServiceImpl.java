package com.realcoderz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.Recuter;
import com.realcoderz.repository.IRecuterRepo;
@Service("recuter")
public class RecuterServiceImpl implements IRecuterService {

	@Autowired
	private IRecuterRepo repo;
	
	
	@Override
	public String saveRecuterDetails(Recuter recuter) {
		Recuter recuter1=repo.save(recuter);
		return recuter!=null?"Your recored has been saved with the id recutermanager:: "+recuter.getRecuterId():"Your recored has been not saved please try again..";
	
	}
	@Override
	public List<Recuter> getAllRecuter(String recutercategory) {
		List<Recuter> listRecuter=repo.getAllRecuter(recutercategory);
		
		return listRecuter;
	}
	
	@Override
	public List<Recuter> getAllRecuter() {
		
		return repo.findAll();
	}
	
	@Override
	public List<Recuter> getRecuterByName(String name) {
		return repo.getRecuterByRecuterName(name);
	}
	@Override
	public Long countRecruiter() {
		return repo.count();
	}
	
}