package com.demo.batch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCount {

	@Id
	private String name;
	private Long noOfProducts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(Long noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	ProductCount()
	{
		
	}
	public ProductCount(String name, Long noOfProducts) {
		super();
		this.name = name;
		this.noOfProducts = noOfProducts;
	}
	@Override
	public String toString() {
		return "ProductCount [name=" + name + ", noOfProducts=" + noOfProducts + "]";
	}
	
}
