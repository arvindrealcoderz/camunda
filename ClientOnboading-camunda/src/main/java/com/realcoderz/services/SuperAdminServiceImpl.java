package com.realcoderz.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.Client;
import com.realcoderz.repository.ISuperAdminRepo;

@Service("service")
public class SuperAdminServiceImpl implements ISuperAdminService {

	@Autowired
	private ISuperAdminRepo superAdminRepo;
	Map<String, Object> map=new HashMap<String, Object>();
	@Override
	public Integer saveRecored(Client admin) {
		
		Client superAdmin= superAdminRepo.save(admin);
		return superAdmin.getId();
	}
	@Override
	public List<Client> getAllClient() {
		
		/*
		 * List list= superAdminRepo.getAllClient(); for (int i = 0; i < list.size();
		 * i++) { map.put("Id", list) }
		 */
		/*
		 * list.stream().forEach(value -> { map.put("ID", value); });
		 */
		
		return superAdminRepo.getAllClient();
	}

}
