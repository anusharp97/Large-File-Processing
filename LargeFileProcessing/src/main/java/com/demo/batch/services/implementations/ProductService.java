package com.demo.batch.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.batch.entity.Product;
import com.demo.batch.repository.IProductRepository;
import com.demo.batch.services.interfaces.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productService;

	@Override
	public List<Product> findProductsBySku(String sku) {
		return productService.findProductsBySku(sku);

	}

	@Override
	public List<Product> findAll() {
		return productService.findAll();

	}

	@Override
	public boolean existsBySku(String sku) {
		return productService.existsBySku(sku);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productService.findById(id);
	}

}
