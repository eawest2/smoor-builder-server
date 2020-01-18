package com.smoorbuilderserver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "character")
@NamedQuery(name = "Character.findById", query = "from Character c where c.id = ?1")
public class Character {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@OneToMany
	@JoinColumn(name = "user")
	private Integer user;
	
	@Column(name = "build_total")
	private Integer buildTotal;
	
	@Column(name = "character_name")
	private String characterName;
	
	@OneToMany
	@JoinColumn(name = "race")
	private Integer race;
	
	@OneToMany
	@JoinColumn(name = "class")
	private Integer classType;

	@Column(name = "background")
	private String background;
	
	@Column(name = "description")
	@Lob
	private String description;
	
	@Column(name = "image")
	private String image;

	public Character() {};
	
	public Character(
			Integer user, Integer buildTotal, String characterName,
			Integer race, Integer classType, String background, 
			String description, String image) 
	{
		this.user = user;
		this.buildTotal = buildTotal;
		this.characterName = characterName;
		this.race = race;
		this.classType = classType;
		this.background = background;
		this.description = description;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getBuildTotal() {
		return buildTotal;
	}

	public void setBuildTotal(Integer buildTotal) {
		this.buildTotal = buildTotal;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Integer getRace() {
		return race;
	}

	public void setRace(Integer race) {
		this.race = race;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}