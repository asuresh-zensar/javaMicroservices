package com.zensar.olx.model;


public class AdvStatus {

	private int id;
	private String status;
	
	
	public AdvStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public AdvStatus() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "AdvStatus [id=" + id + ", status=" + status + "]";
	}
	

}
