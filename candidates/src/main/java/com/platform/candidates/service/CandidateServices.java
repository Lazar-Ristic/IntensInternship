package com.platform.candidates.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.candidates.entities.Candidate;
import com.platform.candidates.entities.Skills;
import com.platform.candidates.repository.CandidateRepo;
import com.platform.candidates.repository.SkillsRepo;

@Service
public class CandidateServices {

	@Autowired
	private CandidateRepo candidateRepo;
	@Autowired
	private SkillsRepo skillRepo;
	
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

	public void updateCandidate(Candidate candidate) {
		Candidate candidateForUpdate = candidateRepo.findById(candidate.getId()).get();	
		List<Skills> skillListForSave = new ArrayList<Skills>();
		List<Skills> skillList = candidate.getSkillList();
		for (Skills skills : skillList) {
			Skills skillFromDB = skillRepo.findById(skills.getId()).get();
			skillListForSave.add(skillFromDB);
		}
		candidateForUpdate.setSkillList(skillListForSave);
		candidateRepo.save(candidateForUpdate);
	}

	public List<Candidate> allCandidate() {
		return candidateRepo.findAll();	
	}
}
