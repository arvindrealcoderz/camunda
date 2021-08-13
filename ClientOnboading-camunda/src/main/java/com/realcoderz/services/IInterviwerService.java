package com.realcoderz.services;

import java.util.List;

import com.realcoderz.entity.InterView;

public interface IInterviwerService {
	
	public String saveInterviewerDeatils(InterView interview);
	public List<InterView>  getAllInterviwer(String profile,String category);
	public List<InterView>  getAllInterviwerDetails();
	public Long countInterviewer();
	public List<InterView> getAllInterviwerProfileBased(String category);
	public String delete(Integer id);

}
