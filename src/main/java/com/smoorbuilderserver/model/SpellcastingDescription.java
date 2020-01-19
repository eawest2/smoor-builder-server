package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "spellcasting_description", schema = "public")
public class SpellcastingDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "spellcasting_name")
	private String spellcastingName;
	
	@Column(name = "spellcasting_description")
	@Lob
	private String spellcastingDescription;

	public SpellcastingDescription() {};
	
	public SpellcastingDescription(
			String spellcastingName, String spellcastingDescription) 
	{
		this.spellcastingName = spellcastingName;
		this.spellcastingDescription = spellcastingDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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