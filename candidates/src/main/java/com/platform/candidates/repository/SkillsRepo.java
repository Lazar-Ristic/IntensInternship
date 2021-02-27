package com.platform.candidates.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.candidates.entities.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Long> {

}
