package com.smoorbuilderserver.model;

import javax.persistence.CascadeType;
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
    private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="general_skill_description_id", referencedColumnName="id", nullable = false)
	private GeneralSkillDescription generalSkillDescription;

	public CharacterGeneralSkillInventory() {};
	
	public CharacterGeneralSkillInventory(
			User user, GeneralSkillDescription generalSkillDescription) 
	{
		this.user = user;
		this.generalSkillDescription = generalSkillDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
