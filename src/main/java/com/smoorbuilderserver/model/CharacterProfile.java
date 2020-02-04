package com.smoorbuilderserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "character", schema = "public")
public class CharacterProfile {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonProperty("user_id")
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
	private User user;
	
    @JsonProperty("build_total")
	@Column(name = "build_total")
	private Integer buildTotal;
	
    @JsonProperty("character_name")
	@Column(name = "character_name", nullable = false)
	private String characterName;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("race_description_id")
	@JoinColumn(name="race_description_id", referencedColumnName="id", nullable = false)
	private RaceDescription raceDescription;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("class_description_id")
	@JoinColumn(name="class_description_id", referencedColumnName="id", nullable = false)
	private ClassDescription classDescription;
	
	@JsonProperty("background")
	@Column(name = "background", columnDefinition = "TEXT")
	private String background;
	
	@JsonProperty("description")
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@JsonProperty("image")
	@Column(name = "image")
	private String image;

	public CharacterProfile() {};
	
	public CharacterProfile(
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