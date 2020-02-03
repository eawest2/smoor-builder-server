package com.smoorbuilderserver.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
	
	@Column(unique = true, name = "username", nullable = false)
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email",  nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "account_active")
	private Boolean accountActive;
	
	@Column(name = "gob_total")
	private Integer gobTotal;
	
	@Column(name = "account_role")
	private Integer accountRole;
	
	public User() {};
	
	public User(
			String username, String firstName, String lastName,
			String email, String password, Date createDate, 
			Boolean accountActive, Integer gobTotal, Integer accountRole) 
	{
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.accountActive = accountActive;
		this.gobTotal = gobTotal;
		this.accountRole = accountRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getAccountActive() {
		return accountActive;
	}

	public void setAccountActive(Boolean accountActive) {
		this.accountActive = accountActive;
	}

	public Integer getGobTotal() {
		return gobTotal;
	}

	public void setGobTotal(Integer gobTotal) {
		this.gobTotal = gobTotal;
	}

	public Integer getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(Integer accountRole) {
		this.accountRole = accountRole;
	}

}