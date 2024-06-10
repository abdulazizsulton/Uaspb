package com.example.uaspb.response.selectPost;

import com.google.gson.annotations.SerializedName;

public class PostData {

	@SerializedName("image")
	private String image;

	@SerializedName("post_id")
	private int postId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("profile_picture")
	private String profilePicture;

	@SerializedName("content")
	private String content;

	@SerializedName("username")
	private String username;

	@SerializedName("pet_id")
	private int petId;

	public String getImage(){
		return image;
	}

	public int getPostId(){
		return postId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getProfilePicture(){
		return profilePicture;
	}

	public String getContent(){
		return content;
	}

	public String getUsername(){
		return username;
	}

	public int getPetId(){
		return petId;
	}
}