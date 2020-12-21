package com.tts.UsersAPI.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	@Length(max = 20, message = "Your firstName cannot have more than 20 characters")
	private String lastName;
	@Length(min = 2, message = "Your lastName cannont have less than 2 characters")
	private String state;
	@Length(min = 4, max = 20, message = "Your state must be between 4 to 20 characters")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User() {}
	
	public User(Long id, String firstName, String lastName, String state) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
	}

}
