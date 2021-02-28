package com.platform.candidates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.candidates.entities.Candidate;
import com.platform.candidates.entities.Skills;
import com.platform.candidates.service.CandidateServices;
import com.platform.candidates.service.SkillsServices;

@RestController
public class PlatformController {

	@Autowired
    private CandidateServices candidateService;
	@Autowired
	private SkillsServices skillsServices;
	
	@GetMapping("/welcome")
	public String test() {
		return "test";
	}
	
	@PostMapping("/candidateAdd")
	public ResponseEntity<Object> addNewCandidate(@RequestBody Candidate candidate){
		candidateService.addJobCandidate(candidate);
		return new ResponseEntity<Object>("succesfuly added new candidate", HttpStatus.CREATED);
	}
	
	@PostMapping("/candidateRemove")
	public ResponseEntity<Object> removeNewCandidate(@RequestBody Candidate candidate){
		candidateService.removeJobCandidate(candidate);
		return new ResponseEntity<Object>("succesfuly removed new candidate", HttpStatus.OK);
	}
	
	@GetMapping("/candidateSearch")
	public ResponseEntity<Object> searchForCandidate(@RequestParam String name){
		List<Candidate> searchCandidate = candidateService.getByName(name);
		return new ResponseEntity<Object>(searchCandidate, HttpStatus.OK);
	}
	
	@PostMapping("/skillAdd")
	public ResponseEntity<Object> addNewSkill(@RequestBody Skills skill){
		skillsServices.addNewSkill(skill);
		return new ResponseEntity<Object>("succesfuly added new skill", HttpStatus.CREATED);
	}
	
	@PutMapping("/candidateUpdate/{candidateId}")
	public ResponseEntity<Object> candidateUpdate(@PathVariable Long candidateId, @RequestBody List<Skills> skillList){
		candidateService.updateCandidate(candidateId, skillList);
		return new ResponseEntity<Object>("succesfuly updated new skill", HttpStatus.OK);
	}
	
	@PutMapping("/candidateRemoveSkills/{candidateId}")
	public ResponseEntity<Object> candidateRemoveSkills(@PathVariable Long candidateId, @RequestBody List<Skills> skillList){
		candidateService.removeSkillsFromCandidate(candidateId, skillList);
		return new ResponseEntity<Object>("succesfuly updated new skill", HttpStatus.OK);
	}
	
	@GetMapping("/allCandidates")
	public ResponseEntity<Object> allCandidate(){
		List<Candidate> candidateList = candidateService.allCandidate();
		return new ResponseEntity<Object>(candidateList, HttpStatus.OK);
	}
	
	@GetMapping("/allSkills")
	public ResponseEntity<Object> allSkills(){
		List<Skills> skillsList = skillsServices.getAllSkills();
		return new ResponseEntity<Object>(skillsList, HttpStatus.OK);
	}
	
	@GetMapping("/candidatesBySkill")
	public ResponseEntity<Object> getCandidatesBySkill(@RequestParam Long skillId){
		List<Candidate> candidateList = candidateService.findBySkill(skillId);
		return new ResponseEntity<Object>(candidateList, HttpStatus.OK);
	}

}
