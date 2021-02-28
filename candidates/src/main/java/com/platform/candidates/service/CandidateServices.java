package com.platform.candidates.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
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


	public List<Candidate> allCandidate() {
		return candidateRepo.findAll();	
	}
	
	@Transactional
	public void updateCandidate(Long candidateId, List<Skills> skillList) {
		Candidate candidateForUpdate = candidateRepo.findById(candidateId).orElse(null);
		if(candidateForUpdate != null) {
			Hibernate.initialize(candidateForUpdate.getSkillList());
			candidateForUpdate.getSkillList().addAll(skillList);
			candidateRepo.save(candidateForUpdate);
		}else {
			System.out.println("Candidate not found");
		}
		
	}

	@Transactional
	public void removeSkillsFromCandidate(Long candidateId, List<Skills> skillList) {
		Candidate candidateForUpdate = candidateRepo.findById(candidateId).orElse(null);
		if(candidateForUpdate != null) {
			Hibernate.initialize(candidateForUpdate.getSkillList());
			this.removeFromList(candidateForUpdate.getSkillList(), skillList);;
			candidateRepo.save(candidateForUpdate);
		}else {
			System.out.println("Candidate not found");
		}
		
	}

	private void removeFromList(List<Skills> skillListForUpadate, List<Skills> skillListToRemove) {
		for (Skills skillsToRemove : skillListToRemove) {
			for (int i = 0; i < skillListForUpadate.size(); i++) {
				if(skillsToRemove.getId().compareTo(skillListForUpadate.get(i).getId()) == 0) {
					skillListForUpadate.remove(i);
				}
			}
		}
		
	}

	
	public List<Candidate> findBySkill(Long skillId) {
		List<Candidate> candidateList = skillRepo.findCandidatesBySkill(skillId);
		return candidateList;
	}

	public List<Candidate> getByName(String name) {
		List<Candidate> candidateList = candidateRepo.findByName(name);
		return candidateList;
	}
}
