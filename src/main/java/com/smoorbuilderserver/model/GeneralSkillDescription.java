package com.smoorbuilderserver.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "general_skill_description", schema = "public")
public class GeneralSkillDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
	
	@JsonProperty("skill_cost")
	@Column(name = "skill_cost", nullable = false)
	private Integer generalSkillCost;
	
	@JsonProperty("skill_description")
	@Column(name = "skill_description", nullable = false, columnDefinition = "TEXT")
	private String generalSkillDescription;
	
	@JsonProperty("skill_name")
	@Column(name = "skill_name", unique = true, nullable = false)
	private String generalSkillName;
	
	@JsonProperty("skill_restricted_status")
	@Column(name = "skill_restricted_status", nullable = false)
	private Integer generalSkillRestrictedStatus;

	public GeneralSkillDescription() {};
	
	public GeneralSkillDescription(
			String generalSkillName, Integer generalSkillCost, String generalSkillDescription, Integer generalSkillRestrictedStatus) 
	{
		this.generalSkillName = generalSkillName;
		this.generalSkillCost = generalSkillCost;
		this.generalSkillDescription = generalSkillDescription;
		this.generalSkillRestrictedStatus = generalSkillRestrictedStatus;
	}
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getGeneralSkillName() {
		return generalSkillName;
	}

	public void setGeneralSkillName(String generalSkillName) {
		this.generalSkillName = generalSkillName;
	}

	public Integer getGeneralSkillCost() {
		return generalSkillCost;
	}

	public void setGeneralSkillCost(Integer generalSkillCost) {
		this.generalSkillCost = generalSkillCost;
	}

	public String getGeneralSkillDescription() {
		return generalSkillDescription;
	}

	public void setGeneralSkillDescription(String generalSkillDescription) {
		this.generalSkillDescription = generalSkillDescription;
	}

	public Integer getGeneralSkillRestrictedStatus() {
		return generalSkillRestrictedStatus;
	}

	public void setGeneralSkillRestrictedStatus(Integer generalSkillRestrictedStatus) {
		this.generalSkillRestrictedStatus = generalSkillRestrictedStatus;
	}

}