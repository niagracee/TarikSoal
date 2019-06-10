package com.niyagrace.tariksoal.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMateri{

	@SerializedName("list_materi")
	private List<ListMateriItem> listMateri;

	public void setListMateri(List<ListMateriItem> listMateri){
		this.listMateri = listMateri;
	}

	public List<ListMateriItem> getListMateri(){
		return listMateri;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMateri{" + 
			"list_materi = '" + listMateri + '\'' + 
			"}";
		}
}