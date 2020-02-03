package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "class_description", schema = "public")
public class ClassDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@JsonProperty("class_name")
	@Column(name = "class_name", unique = true, nullable = false)
	private String className;
	
	@JsonProperty("class_description")
	@Column(name = "class_description", nullable = false, columnDefinition = "TEXT")
	private String classDescription;

	public ClassDescription() {};
	
	public ClassDescription(
			String className, String classDescription) 
	{
		this.className = className;
		this.classDescription = classDescription;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

}