package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "production_skill_description", schema = "public")
public class ProductionSkillDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("production_name")
	@Column(name = "production_name", unique = true, nullable = false)
	private String productionSkillName;
	
	@JsonProperty("production_description")
	@Column(name = "production_description" , nullable = false, columnDefinition = "TEXT")
	private String productionSkillDescription;

	public ProductionSkillDescription() {};
	
	public ProductionSkillDescription(
			String productionSkillName, String productionSkilDescription) 
	{
		this.productionSkillName = productionSkillName;
		this.productionSkillDescription = productionSkilDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductionSkillName() {
		return productionSkillName;
	}

	public void setProductionSkillName(String productionSkillName) {
		this.productionSkillName = productionSkillName;
	}

	public String getProductionSkilDescription() {
		return productionSkillDescription;
	}

	public void setProductionSkilDescription(String productionSkilDescription) {
		this.productionSkillDescription = productionSkilDescription;
	}

}