package it.federicomollica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRegisterDto {
	@NotNull
	@Pattern(regexp = "[a-zA-Z\\s']{5,50}") 
	private String firstname;

	@NotNull
	@Pattern(regexp = "[a-zA-Z\\s']{5,50}") 
	private String lastname;

	@NotNull
	@Pattern(regexp = "[A-Za-z0-9\\.\\+_-]+@[A-Za-z0-9\\._-]+\\.[A-Za-z]{2,24}")
	private String email;
	
	@NotNull
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
	
}
