package com.revature.beans.dtos;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class LoginRequest {
	@NotBlank
	private String username;

	@Length(min = 1)
	private char[] password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + Arrays.toString(password) + "]";
	}

	public LoginRequest(String username, char[] password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginRequest() {
		super();
	}

}
