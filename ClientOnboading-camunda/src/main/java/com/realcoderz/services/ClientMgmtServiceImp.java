package com.realcoderz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.Client;
import com.realcoderz.repository.IClientRepo;

@Service("comservice")
public class ClientMgmtServiceImp implements IClientService{

	
	@Autowired
	private IClientRepo repo;
	@Override
	public Client insertRecored(Client client) {
		return  repo.save(client);
	}
	
	

}
