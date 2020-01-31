package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "combat_action_description")
public class CombatActionDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@JsonProperty("action_name")
	@Column(name = "action_name")
	private String actionName;
	
	@JsonProperty("action_description")
	@Column(name = "action_description")
	@Lob
	private String actionDescription;

	public CombatActionDescription() {};
	
	public CombatActionDescription(
			String actionName, String actionDescription) 
	{
		this.actionName = actionName;
		this.actionDescription = actionDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

}
