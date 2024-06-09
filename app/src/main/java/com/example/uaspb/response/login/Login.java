package com.example.uaspb.response.login;



import com.google.gson.annotations.SerializedName;

public class Login {
	@SerializedName("status")
	private boolean status;

	@SerializedName("message")
	private String message;

	@SerializedName("data")
	private LoginData data;

	public boolean isStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LoginData getData() {
		return data;
	}
}
