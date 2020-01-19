package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "character", schema = "public")
@NamedQuery(name = "Character.findById", query = "from Character c where c.id = ?1")
public class Character {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
	
	@Column(name = "build_total")
	private Integer buildTotal;
	
	@Column(name = "character_name", nullable = false)
	private String characterName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="race_description_id", referencedColumnName="id", nullable = false)
	private RaceDescription raceDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="class_description_id", referencedColumnName="id", nullable = false)
	private ClassDescription classDescription;

	@Column(name = "background")
	private String background;
	
	@Column(name = "description")
	@Lob
	private String description;
	
	@Column(name = "image")
	private String image;

	public Character() {};
	
	public Character(
			User user, Integer buildTotal, String characterName,
			RaceDescription raceDescription, ClassDescription classDescription, String background, 
			String description, String image) 
	{
		this.user = user;
		this.buildTotal = buildTotal;
		this.characterName = characterName;
		this.raceDescription = raceDescription;
		this.classDescription = classDescription;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public RaceDescription getRaceDescription() {
		return raceDescription;
	}

	public void setRaceDescription(RaceDescription raceDescription) {
		this.raceDescription = raceDescription;
	}

	public ClassDescription getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(ClassDescription classDescription) {
		this.classDescription = classDescription;
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