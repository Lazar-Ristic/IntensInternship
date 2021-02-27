package com.platform.candidates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.candidates.entities.Skills;
import com.platform.candidates.repository.SkillsRepo;

@Service
public class SkillsServices {
	
	@Autowired
	private SkillsRepo skillsRepo;
	
	public void addNewSkill(Skills skill) {
		skillsRepo.save(skill);
	}
	
	public List<Skills> getAllSkills(){
		return skillsRepo.findAll();
	}
}
