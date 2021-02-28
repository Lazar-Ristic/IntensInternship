package com.platform.candidates.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.platform.candidates.entities.Candidate;

@Transactional
public interface CandidateRepo extends JpaRepository<Candidate, Long> {

	public List<Candidate> findAll();
	
//	@Query("from Candidate cr where cr.id = :id")
	public Optional<Candidate> findById(Long id);
	
	public List<Candidate> findByName(String name);
}
