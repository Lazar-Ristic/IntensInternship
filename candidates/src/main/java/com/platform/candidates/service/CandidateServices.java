package com.platform.candidates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.candidates.entities.Candidate;
import com.platform.candidates.repository.CandidateRepo;

@Service
public class CandidateServices {

	@Autowired
	private CandidateRepo candidateRepo;
	
	public void addJobCandidate(Candidate candidate) {
		candidateRepo.save(candidate);
	}

	public void removeJobCandidate(Candidate candidate) {
		candidateRepo.delete(candidate);
	}

	public Candidate searchForCandidate(Candidate candidate) {
		if(candidateRepo.equals(candidate))
			return candidate;
		else return null;
	}
}
