package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "general_skill_description", schema = "public")
public class GeneralSkillDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "skill_name")
	private String generalSkillName;
	
	@Column(name = "skill_cost")
	private Integer generalSkillCost;
	
	@Column(name = "skill_description")
	@Lob
	private String generalSkillDescription;
	
	@Column(name = "skill_restricted_status")
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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