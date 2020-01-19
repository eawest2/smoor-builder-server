package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "production_skill_description", schema = "public")
public class ProductionSkillDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "production_name")
	private String productionSkillName;
	
	@Column(name = "production_description")
	@Lob
	private String productionSkilDescription;

	public ProductionSkillDescription() {};
	
	public ProductionSkillDescription(
			String productionSkillName, String productionSkilDescription) 
	{
		this.productionSkillName = productionSkillName;
		this.productionSkilDescription = productionSkilDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductionSkillName() {
		return productionSkillName;
	}

	public void setProductionSkillName(String productionSkillName) {
		this.productionSkillName = productionSkillName;
	}

	public String getProductionSkilDescription() {
		return productionSkilDescription;
	}

	public void setProductionSkilDescription(String productionSkilDescription) {
		this.productionSkilDescription = productionSkilDescription;
	}

}