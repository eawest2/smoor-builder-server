package com.smoorbuilderserver.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "race_description", schema = "public")
public class RaceDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("race_name")
	@Column(name = "race_name", unique = true, nullable = false)
	private String raceName;
	
	@JsonProperty("race_description")
	@Column(name = "race_description", nullable = false, columnDefinition = "TEXT")
	private String raceDescription;

	public RaceDescription() {};
	
	public RaceDescription(
			String raceName, String raceDescription) 
	{
		this.raceName = raceName;
		this.raceDescription = raceDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getRaceDescription() {
		return raceDescription;
	}

	public void setRaceDescription(String raceDescription) {
		this.raceDescription = raceDescription;
	}

}