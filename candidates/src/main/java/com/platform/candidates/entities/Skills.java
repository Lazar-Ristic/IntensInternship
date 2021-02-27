package com.platform.candidates.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name="skills")
public class Skills {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String skillName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CANDIDATE_SKILLS", joinColumns = {
			@JoinColumn(name = "SKILL", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "CANDIDATE", nullable = false, updatable = true) })
	private List<Candidate> candidateList = new ArrayList<>();
	
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
