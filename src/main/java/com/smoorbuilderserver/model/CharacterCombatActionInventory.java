package com.smoorbuilderserver.model;

import java.math.BigInteger;

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
@Table(name = "character_combat_action")
public class CharacterCombatActionInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="combat_action_description_id", referencedColumnName="id", nullable = false)
	private CombatActionDescription combatActionDescription;
	
	@Column(name = "combat_action_total")
	private Integer characterCombatActionTotal;

	public CharacterCombatActionInventory() {};
	
	public CharacterCombatActionInventory(
			User user, CombatActionDescription combatActionDescription, Integer characterCombatActionTotal) 
	{
		this.user = user;
		this.combatActionDescription = combatActionDescription;
		this.characterCombatActionTotal = characterCombatActionTotal;
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
