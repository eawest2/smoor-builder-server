package com.smoorbuilderserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "combat_action_description")
public class CombatActionDescription  implements Serializable{
	
	@Id
	@JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("action_name")
	@Column(name = "action_name", unique = true, nullable = false)
	private String actionName;
	
	@JsonProperty("action_description")
	@Column(name = "action_description", nullable = false, columnDefinition = "TEXT")
	private String actionDescription;

	public CombatActionDescription() {};
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public CombatActionDescription(
			String actionName, String actionDescription) 
	{
		this.actionName = actionName;
		this.actionDescription = actionDescription;
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
