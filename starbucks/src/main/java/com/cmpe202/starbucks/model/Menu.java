

package com.cmpe202.starbucks.model;

import javax.persistence.*;


@Entity
@Table(name = "Menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name="Type",length = 9)
    private String type;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private Double price;

	@Column(name="Image")
	private String image;

	@Column(name="Description")
	private String description;

    public Menu() {

    }

    public Menu(String type, String name, Double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setImage(String image) {
		this.image = image;
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
}