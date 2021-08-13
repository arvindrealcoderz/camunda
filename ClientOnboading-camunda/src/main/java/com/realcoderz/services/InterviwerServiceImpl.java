package com.realcoderz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.entity.InterView;
import com.realcoderz.repository.IInterviwerRepo;
@Service("interviwerService")
public class InterviwerServiceImpl implements IInterviwerService {
	
	
	@Autowired
	private IInterviwerRepo repo;

	
	@Override
	public String saveInterviewerDeatils(InterView interview) {
		return repo.save( interview)!=null?"interviwer data has save ":"Interview Data has not save";
	}

	@Override
	public List<InterView>  getAllInterviwer(String profile,String category){
	
		return repo.getAllInterviwer(profile, category);
	}

	@Override
	public List<InterView> getAllInterviwerDetails() {
		return repo.getAllInterviwerDetails();
	}

	@Override
	public Long countInterviewer() {
		return repo.count();
	}

	
@Override
public List<InterView> getAllInterviwerProfileBased(String category) {
	System.out.println("-----------------category--------"+category);
	return repo.getAllInterviwerProfileBased(category);
}

@Override
public String delete(Integer id) {
		
	Optional<InterView> opt=	repo.findById(id);
	if(opt!=null) {
		repo.deleteById(id);
		return "Your Recored are deleted ";
		
	}
	else
		return "Your Recored are not deleted ";
	
	
}
	
}