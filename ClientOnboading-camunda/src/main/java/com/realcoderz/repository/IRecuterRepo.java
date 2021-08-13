package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.realcoderz.entity.Recuter;
import com.realcoderz.entity.RecuterManager;


public interface IRecuterRepo extends CrudRepository<Recuter, Integer>,JpaRepository<Recuter, Integer> {
	@Query("FROM Recuter where recutercategory=:recutercategory ")
	public List<Recuter>  getAllRecuter(@Param("recutercategory" )String recutercategory);
	
	@Query("FROM Recuter where recuter_name=:name ")
	public List<Recuter>  getRecuterByRecuterName(@Param("name") String name);
	

}