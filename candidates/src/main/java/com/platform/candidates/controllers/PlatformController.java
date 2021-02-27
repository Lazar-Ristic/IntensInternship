package com.platform.candidates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Object> searchForCandidate(@RequestBody Candidate candidate){
		Candidate searchCandidate = candidateService.searchForCandidate(candidate);
		if(searchCandidate != null)
			return new ResponseEntity<Object>("succesfuly found candidate", HttpStatus.OK);
		else return new ResponseEntity<Object>("candidate not found", HttpStatus.OK);
	}
	
	@PostMapping("/skillAdd")
	public ResponseEntity<Object> addNewSkill(@RequestBody Skills skill){
		skillsServices.addNewSkill(skill);
		return new ResponseEntity<Object>("succesfuly added new skill", HttpStatus.CREATED);
	}
	
	@PutMapping("/candidateUpdate")
	public ResponseEntity<Object> candidateUpdate(@RequestBody Candidate candidate){
		candidateService.updateCandidate(candidate);
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

}
