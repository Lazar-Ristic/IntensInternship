package com.platform.candidates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.platform.candidates.entities.Candidate;
import com.platform.candidates.entities.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Long> {

	@Query("select sk.candidateList from Skills sk where sk.id = :skillId")
	List<Candidate> findCandidatesBySkill(Long skillId);
}
