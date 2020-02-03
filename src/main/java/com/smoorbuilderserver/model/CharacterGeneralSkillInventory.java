package com.smoorbuilderserver.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "character_general_skill")
public class CharacterGeneralSkillInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="general_skill_description_id", referencedColumnName="id", nullable = false)
	private GeneralSkillDescription generalSkillDescription;

	public CharacterGeneralSkillInventory() {};
	
	public CharacterGeneralSkillInventory(
			User user, GeneralSkillDescription generalSkillDescription) 
	{
		this.user = user;
		this.generalSkillDescription = generalSkillDescription;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GeneralSkillDescription getGeneralSkillDescription() {
		return generalSkillDescription;
	}

	public void setGeneralSkillDescription(GeneralSkillDescription generalSkillDescription) {
		this.generalSkillDescription = generalSkillDescription;
	}
	
}
