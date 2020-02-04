package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "spellcasting_description", schema = "public")
public class SpellcastingDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@JsonProperty("spellcasting_name")
	@Column(name = "spellcasting_name", unique = true, nullable = false)
	private String spellcastingName;
	
	@JsonProperty("spellcasting_description")
	@Column(name = "spellcasting_description", nullable = false, columnDefinition = "TEXT")
	private String spellcastingDescription;

	public SpellcastingDescription() {};
	
	public SpellcastingDescription(
			String spellcastingName, String spellcastingDescription) 
	{
		this.spellcastingName = spellcastingName;
		this.spellcastingDescription = spellcastingDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpellcastingName() {
		return spellcastingName;
	}

	public void setSpellcastingName(String spellcastingName) {
		this.spellcastingName = spellcastingName;
	}

	public String getSpellcastingDescription() {
		return spellcastingDescription;
	}

	public void setSpellcastingDescription(String spellcastingDescription) {
		this.spellcastingDescription = spellcastingDescription;
	}

}