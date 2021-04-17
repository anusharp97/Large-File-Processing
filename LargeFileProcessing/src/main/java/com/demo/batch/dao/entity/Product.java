package com.demo.batch.dao.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @Column (name = "ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String sku;
    private String description;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product()
	{
		
	}
	public Product(String name, String sku, String description) {
		super();
		this.name = name;
		this.sku = sku;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", sku=" + sku + ", description=" + description + "]";
	}
	
}
