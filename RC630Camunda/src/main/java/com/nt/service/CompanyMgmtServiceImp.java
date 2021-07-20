package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Company;
import com.nt.repo.ICompanyRepo;
@Service("comservice")
public class CompanyMgmtServiceImp implements ICompanyService{

	@Autowired
	private ICompanyRepo repo;
	@Override
	public String companyRegister(Company company) {
		Company comp= repo.save(company);
		return comp!=null?"Company registration success":"Company Registration failed";
	
	}

}
