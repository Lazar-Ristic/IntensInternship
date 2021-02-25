package com.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entities.Candidate;
import com.platform.service.CandidateServices;

@RestController
//@RequestMapping("/rest")
public class PlatformController {

	@Autowired
    private CandidateServices candidateService;
	
	@GetMapping("/welcome")
	public String test() {
		return "test";
	}
	
	@PostMapping("/candidate")
	public ResponseEntity<Object> addNewCandidate(@RequestBody Candidate candidate){
		candidateService.addJobCandidate(candidate);
		return new ResponseEntity<Object>("succesfuly added new candidate", HttpStatus.CREATED);
	}
}
