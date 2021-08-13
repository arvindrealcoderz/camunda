package com.realcoderz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.JobProfile;
import com.realcoderz.repository.IProfileRepo;

@Service("jobprofile")
public class JobProfileServiceImpl implements IJobProfileService{

	
	@Autowired
	private IProfileRepo repo;
	@Override
	public JobProfile save(JobProfile profile) {
		
		return repo.save(profile);
	}
	@Override
	public List<JobProfile> getAllClient() {
		
		return repo.getAllClient();
	}
	@Override
	public long countJobProfile() {
		return repo.count();
	}
}