package com.niyagrace.tariksoal.response;

import com.google.gson.annotations.SerializedName;

public class ListMateriItem{

	@SerializedName("materi")
	private String materi;

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	public void setMateri(String materi){
		this.materi = materi;
	}

	public String getMateri(){
		return materi;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	@Override
 	public String toString(){
		return 
			"ListMateriItem{" + 
			"materi = '" + materi + '\'' + 
			",id = '" + id + '\'' + 
			",judul = '" + judul + '\'' + 
			"}";
		}
}