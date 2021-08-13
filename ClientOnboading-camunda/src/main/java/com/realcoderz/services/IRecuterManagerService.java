package com.realcoderz.services;

import java.util.List;

import com.realcoderz.entity.RecuterManager;

public interface IRecuterManagerService {
	
	public String saveRecuterDetails(RecuterManager recutermanager);
	public List<RecuterManager>  getAllRecuterManager();
	

}
