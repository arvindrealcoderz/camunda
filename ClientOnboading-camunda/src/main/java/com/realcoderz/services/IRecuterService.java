package com.realcoderz.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.realcoderz.entity.Recuter;

public interface IRecuterService {
	
	public String saveRecuterDetails(Recuter recuter);
	public List<Recuter>  getAllRecuter(String recutercategory);
	public List<Recuter> getAllRecuter();
	public List<Recuter>  getRecuterByName(String name);
	public Long countRecruiter();
}
