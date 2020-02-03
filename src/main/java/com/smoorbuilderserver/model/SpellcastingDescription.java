package com.smoorbuilderserver.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "spellcasting_description", schema = "public")
public class SpellcastingDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

	@JsonProperty("spellcasting_name")
	@Column(name = "spellcasting_name", unique = true, nullable = false)
	private String spellcastingName;
	
	@JsonProperty("spellcasting_description")
	@Column(name = "spellcasting_description", nullable = false, columnDefinition = "TEXT")
	@Lob
	private String spellcastingDescription;

	public SpellcastingDescription() {};
	
	public SpellcastingDescription(
			String spellcastingName, String spellcastingDescription) 
	{
		this.spellcastingName = spellcastingName;
		this.spellcastingDescription = spellcastingDescription;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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