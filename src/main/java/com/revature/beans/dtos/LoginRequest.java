package com.revature.beans.dtos;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequest {
	@NotBlank(message="Username is required")
	private String username;

	@Size(min=1, message="Password is required.")
	@NotNull
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
