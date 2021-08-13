package com.realcoderz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.realcoderz.entity.RecuterManager;


public interface IRecuterManagerRepo extends CrudRepository<RecuterManager, Integer>,JpaRepository<RecuterManager, Integer> {
	@Query("FROM RecuterManager ")
	public List<RecuterManager>  getAllClient();

}
