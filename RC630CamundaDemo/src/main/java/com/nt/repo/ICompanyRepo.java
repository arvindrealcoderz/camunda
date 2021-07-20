package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Company;

public interface ICompanyRepo extends JpaRepository<Company, Integer>, CrudRepository<Company, Integer> {

}
