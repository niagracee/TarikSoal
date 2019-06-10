package com.niyagrace.tariksoal.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSoal{

	@SerializedName("list_soal")
	private List<ListSoalItem> listSoal;

	public void setListSoal(List<ListSoalItem> listSoal){
		this.listSoal = listSoal;
	}

	public List<ListSoalItem> getListSoal(){
		return listSoal;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSoal{" + 
			"list_soal = '" + listSoal + '\'' + 
			"}";
		}
}