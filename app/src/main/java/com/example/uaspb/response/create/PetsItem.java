package com.example.uaspb.response.create;

import com.google.gson.annotations.SerializedName;

public class PetsItem{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("species")
	private String species;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("profile_picture")
	private Object profilePicture;

	@SerializedName("breed")
	private Object breed;

	@SerializedName("age")
	private String age;

	@SerializedName("pet_id")
	private String petId;

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getUserId(){
		return userId;
	}

	public String getSpecies(){
		return species;
	}

	public String getName(){
		return name;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getProfilePicture(){
		return profilePicture;
	}

	public Object getBreed(){
		return breed;
	}

	public String getAge(){
		return age;
	}

	public String getPetId(){
		return petId;
	}
}