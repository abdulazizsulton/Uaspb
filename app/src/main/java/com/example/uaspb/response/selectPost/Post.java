package com.example.uaspb.response.selectPost;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Post{

	@SerializedName("data")
	private List<PostData> data;

	public List<PostData> getData(){
		return data;
	}

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;
	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}