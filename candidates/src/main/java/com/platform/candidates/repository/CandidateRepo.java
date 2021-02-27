package com.platform.candidates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.platform.candidates.entities.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {

	public List<Candidate> findAll();
	
	@Query("select cr from Candidate cr where cr.name=:name")
	public Candidate findByName(String name);
}
