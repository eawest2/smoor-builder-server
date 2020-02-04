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
@Table(name = "character_spellcasting")
public class CharacterSpellcastningInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="spellcasting_description_id", referencedColumnName="id", nullable = false)
	private SpellcastingDescription spellcastingDescription;
	
	@Column(name = "spellcasting_total")
	private Integer characterSpellcastingTotal;

	public CharacterSpellcastningInventory() {};
	
	public CharacterSpellcastningInventory(
			User user, SpellcastingDescription spellcastingDescription, Integer characterSpellcastingTotal) 
	{
		this.user = user;
		this.spellcastingDescription = spellcastingDescription;
		this.characterSpellcastingTotal = characterSpellcastingTotal;
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

	public SpellcastingDescription getSpellcastingDescription() {
		return spellcastingDescription;
	}

	public void setSpellcastingDescription(SpellcastingDescription spellcastingDescription) {
		this.spellcastingDescription = spellcastingDescription;
	}

	public Integer getCharacterSpellcastingTotal() {
		return characterSpellcastingTotal;
	}

	public void setCharacterSpellcastingTotal(Integer characterSpellcastingTotal) {
		this.characterSpellcastingTotal = characterSpellcastingTotal;
	}

}
