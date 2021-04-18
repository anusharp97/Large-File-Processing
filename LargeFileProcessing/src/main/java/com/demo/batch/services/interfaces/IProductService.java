package com.demo.batch.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.demo.batch.entity.Product;

public interface IProductService {
	
	public List<Product> findProductsBySku(String sku);
	
	public List<Product> findAll();

	public boolean existsBySku(String sku);
	
	public Optional<Product> findById(Long id);

}
