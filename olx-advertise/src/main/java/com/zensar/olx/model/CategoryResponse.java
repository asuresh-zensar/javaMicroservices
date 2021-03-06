package com.zensar.olx.model;

public class CategoryResponse {

	private int id;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public CategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryResponse(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	@Override
	public String toString() {
		return "CategoryResponse [id=" + id + ", category=" + category + "]";
	}
	

}
