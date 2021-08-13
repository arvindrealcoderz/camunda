package com.realcoderz.services;

import java.util.List;

import org.camunda.bpm.engine.runtime.Job;

import com.realcoderz.entity.JobProfile;

public interface IJobProfileService {
	public JobProfile save(JobProfile profile);
	public List<JobProfile>  getAllClient();
	public long countJobProfile();
}
