package com.smoorbuilderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "class_description")
@NamedQuery(name = "ClassDescription.findById", query = "from ClassDescription c where c.id = ?1")
public class ClassDescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "class_description")
	@Lob
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
