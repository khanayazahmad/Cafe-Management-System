package com.cmpe202.starbucks.dto;

public class MenuDto {
	
	private long id;
	private String type;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
    private Double price;
    private String image;
    private String description;
    
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public void setImage(String image) { this.image = image; }
	public String getImage() {
		return image;
	}
	public void setDescription(String description) { this.description = description; }
	public String getDescription() {
		return description;
	}
}
