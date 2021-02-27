package com.platform.candidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platform.candidates.entities.Candidate;
import com.platform.candidates.service.CandidateServices;

@RestController
public class PlatformController {

	
	
	
	@Autowired
    private CandidateServices candidateService;
	
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
	
	@GetMapping("/test")
	public String test1() {
		System.out.println("ok");
		return "test";
	}

}
