package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.realcoderz.entity.Client;

public interface ISuperAdminRepo extends CrudRepository<Client, Integer> ,JpaRepository<Client, Integer> {

	@Query(value = "select Id,Name, Email ,Description,licence FROM Client", nativeQuery = true)
	public List<Client>  getAllClient();

}
