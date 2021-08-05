package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Client;
import com.nt.repo.IClientRepo;

@Service("comservice")
public class ClientMgmtServiceImp implements IClientService{

	
	@Autowired
	private IClientRepo repo;
	@Override
	public Client insertRecored(Client client) {
		return  repo.save(client);
	}
	
	

}
