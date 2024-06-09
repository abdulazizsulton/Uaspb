package com.example.uaspb.response.create;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Pets{

	@SerializedName("Pets")
	private List<PetsItem> pets;

	public List<PetsItem> getPets(){
		return pets;
	}
}