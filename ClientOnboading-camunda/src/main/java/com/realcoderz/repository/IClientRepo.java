package com.realcoderz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.realcoderz.entity.Client;

public interface IClientRepo extends JpaRepository<Client,Integer>, CrudRepository<Client, Integer> {
	
	
	//@Query(value = "SELECT client FROM Client where clientId=:id  ")
	//public Client findAllUsers(Integer id);
	
}
