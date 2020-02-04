package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "character_production_skill")
public class CharacterProductionSkillinventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="production_skill_description_id", referencedColumnName="id", nullable = false)
	private ProductionSkillDescription productionSkillDescription;
	
	@Column(name = "production_skill_total")
	private Long characterProductionSkillTotal;

	public CharacterProductionSkillinventory() {};
	
	public CharacterProductionSkillinventory(
			User user, ProductionSkillDescription productionSkillDescription, Long characterProductionSkillTotal) 
	{
		this.user = user;
		this.productionSkillDescription = productionSkillDescription;
		this.characterProductionSkillTotal = characterProductionSkillTotal;
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

	public ProductionSkillDescription getProductionSkillDescription() {
		return productionSkillDescription;
	}

	public void setProductionSkillDescription(ProductionSkillDescription productionSkillDescription) {
		this.productionSkillDescription = productionSkillDescription;
	}

	public Long getCharacterProductionSkillTotal() {
		return characterProductionSkillTotal;
	}

	public void setCharacterProductionSkillTotal(Long characterProductionSkillTotal) {
		this.characterProductionSkillTotal = characterProductionSkillTotal;
	}
}
