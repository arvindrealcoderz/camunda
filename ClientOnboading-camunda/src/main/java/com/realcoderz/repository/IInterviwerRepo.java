package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.realcoderz.entity.InterView;
import com.realcoderz.entity.Recuter;
import com.realcoderz.entity.RecuterManager;


public interface IInterviwerRepo extends CrudRepository<InterView, Integer>,JpaRepository<InterView, Integer> {
	@Query("FROM InterView where profile=:profile and category =:category ")
	public List<InterView>  getAllInterviwer(@Param("profile" )String profile,@Param("category" )String category);

	@Query("FROM InterView where profile=:profile ")
	public List<InterView>  getAllInterviwerProfileBased(@Param("profile" )String profile);	
	
	
	@Query(" FROM InterView")
	public List<InterView>  getAllInterviwerDetails();
	
	

}
