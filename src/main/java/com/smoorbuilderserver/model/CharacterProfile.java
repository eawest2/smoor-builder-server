package com.smoorbuilderserver.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "character", schema = "public")
public class CharacterProfile implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@JsonProperty("username")
	@Column(name = "username")
	private String username;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="username", referencedColumnName="username", nullable = false,  updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
	private User user;
	
    @JsonProperty("build_total")
	@Column(name = "build_total")
	private Integer buildTotal;
	
    @JsonProperty("character_name")
	@Column(name = "character_name", nullable = false)
	private String characterName;

	@JsonProperty("race_name")
	@Column(name = "race_name")
	private String race_name;

    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="race_name", referencedColumnName="race_name", nullable = false,  updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
	private RaceDescription raceDescription;

	@JsonProperty("class_name")
	@Column(name = "class_name")
	private String class_name;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="class_name", referencedColumnName="class_name", nullable = false,  updatable = false, insertable = false)
	@Fetch(FetchMode.JOIN)
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