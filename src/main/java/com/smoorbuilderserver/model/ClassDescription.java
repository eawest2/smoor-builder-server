package com.smoorbuilderserver.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "class_description", schema = "public")
public class ClassDescription implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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