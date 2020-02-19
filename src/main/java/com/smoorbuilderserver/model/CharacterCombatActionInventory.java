package com.smoorbuilderserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "character_combat_action")
public class CharacterCombatActionInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("character_name")
	@Column(name = "character_name")
	private String character_name;
	
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="character_name", referencedColumnName="character_name", nullable = false,  updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
    private CharacterProfile character;
    
	@JsonProperty("action_name")
	@Column(name = "action_name")
	private String action_name;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="action_name", referencedColumnName="action_name", nullable = false, updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
	private CombatActionDescription combatActionDescription;
	
    @JsonProperty("combat_action_total")
	@Column(name = "combat_action_total")
	private Integer characterCombatActionTotal;

	public CharacterCombatActionInventory() {};
	
	public CharacterCombatActionInventory(
			CharacterProfile character, CombatActionDescription combatActionDescription, Integer characterCombatActionTotal) 
	{
		this.character = character;
		this.combatActionDescription = combatActionDescription;
		this.characterCombatActionTotal = characterCombatActionTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CharacterProfile getCharacter() {
		return character;
	}

	public void setCharacter(CharacterProfile character) {
		this.character = character;
	}

	public CombatActionDescription getCombatActionDescription() {
		return combatActionDescription;
	}

	public void setCombatActionDescription(CombatActionDescription combatActionDescription) {
		this.combatActionDescription = combatActionDescription;
	}

	public Integer getCharacterCombatActionTotal() {
		return characterCombatActionTotal;
	}

	public void setCharacterCombatActionTotal(Integer characterCombatActionTotal) {
		this.characterCombatActionTotal = characterCombatActionTotal;
	}
}
