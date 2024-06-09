package com.example.uaspb.response.login;



import com.google.gson.annotations.SerializedName;

public class LoginData {
	@SerializedName("full_name")
	private String fullName;

	@SerializedName("username")
	private String username;

	// Getter and Setter methods

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
