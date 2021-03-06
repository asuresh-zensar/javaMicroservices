package com.zensar.olx.model;

import java.time.LocalDate;

public class AdvertiseResponse {

	private int id;
	private String title;
	private String category;
	private String status;
	private double price;
	private String description;
	private String photo;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private boolean active;
	private String postedBy;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "AdvertiseResponse [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status
				+ ", price=" + price + ", description=" + description + ", photo=" + photo + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", active=" + active + ", postedBy=" + postedBy
				+ ", username=" + username + "]";
	}
	public AdvertiseResponse(int id, String title, String category, String status, double price, String description,
			String photo, LocalDate createdDate, LocalDate modifiedDate, boolean active, String postedBy,
			String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.active = active;
		this.postedBy = postedBy;
		this.username = username;
	}
	public AdvertiseResponse() {
		super();
	}
	
}
