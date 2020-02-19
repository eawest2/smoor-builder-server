package com.smoorbuilderserver.utils.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterProfileRequest {
	

    @JsonProperty("user_id")
	private Long userId;
	
    @JsonProperty("build_total")
	private Integer buildTotal;
	
    @JsonProperty("character_name")
	private String characterName;
	
	@JsonProperty("race_description_id")
	private Long raceDescriptionId;
	
	@JsonProperty("class_description_id")
	private Long classDescriptionId;
	
	@JsonProperty("background")
	private String background;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("image")
	private String image;

	public CharacterProfileRequest() {};
	
	public CharacterProfileRequest(
			Long userId, Integer buildTotal, String characterName,
			Long raceDescriptionId, Long classDescriptionId, String background, 
			String description, String image) 
	{
		this.userId = userId;
		this.buildTotal = buildTotal;
		this.characterName = characterName;
		this.raceDescriptionId = raceDescriptionId;
		this.classDescriptionId = classDescriptionId;
		this.background = background;
		this.description = description;
		this.image = image;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Long getRaceDescriptionId() {
		return raceDescriptionId;
	}

	public void setRaceDescriptionId(Long raceDescriptionId) {
		this.raceDescriptionId = raceDescriptionId;
	}

	public Long getClassDescriptionId() {
		return classDescriptionId;
	}

	public void setClassDescriptionId(Long classDescriptionId) {
		this.classDescriptionId = classDescriptionId;
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