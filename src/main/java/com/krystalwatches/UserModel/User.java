package com.krystalwatches.UserModel;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long ID;
	
	private String Email;
	
	private String Username;
	
	private String Password;
	
	@Transient
	private String CPassword;
	
	private String Phone;
	
	
	private String Address;
	private int Role = 1;
	private boolean Active = true;

	public int getRole() {
		return Role;
	}

	public void setRole(int role) {
		Role = role;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public User()
	{
		
	}

	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	@NotEmpty(message="Email field is mandatory.")
	public String getEmail() 
	{
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}

	@NotEmpty(message="Username field is mandatory.")
	public String getUsername() 
	{
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}

	@NotEmpty(message="Password field is mandatory.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	
	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getCPassword() {
		return CPassword;
	}


	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}

	@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
    @NotEmpty(message="Phone field is mandatory.")
	public String getPhone() {
		return Phone;
	}
	
	
	public void setPhone(String phone) {
		Phone = phone;
	}

	@NotEmpty(message="Address field is mandatory.")
	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}
}
	
	
