package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entities.Candidate;
import com.platform.repository.CandidateRepo;

@Service
public class CandidateServices {

	@Autowired
	private CandidateRepo candidateRepo;
	
	public void addJobCandidate(Candidate candidate) {
		candidateRepo.save(candidate);
	}
}
