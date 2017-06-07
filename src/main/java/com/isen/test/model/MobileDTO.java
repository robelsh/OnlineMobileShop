package com.isen.test.model;

import org.hibernate.validator.constraints.NotEmpty;

public class MobileDTO {
	
    private int id;
    @NotEmpty
	private String brand;
    
    @NotEmpty
	private int year;
    
    @NotEmpty
	private String description;
    
    @NotEmpty
	private Float price;
    
    @NotEmpty
	private String model;
    
    @NotEmpty
    private int inventory;
    
	@NotEmpty
	private String image;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
