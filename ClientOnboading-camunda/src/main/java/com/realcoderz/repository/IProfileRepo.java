package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.realcoderz.entity.JobProfile;

public interface IProfileRepo  extends CrudRepository<JobProfile, Integer>,JpaRepository<JobProfile, Integer>{
	@Query("FROM JobProfile ")
	public List<JobProfile>  getAllClient();
	


}
