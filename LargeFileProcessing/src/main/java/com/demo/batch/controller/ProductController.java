package com.demo.batch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.batch.entity.Product;
import com.demo.batch.repository.IProductRepository;
import com.demo.batch.services.interfaces.IProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductRepository proService;
	
	@GetMapping(path="/api/products")
	public List<Product> getAllProducts()
	{
		return productService.findAll();
	}
	
	@GetMapping(path="/api/products/{sku}")
	public List<Product> getProductsBySku(@PathVariable String sku)
	{
		return productService.findProductsBySku(sku);
		
	}
	
	@GetMapping(path="api/search/{sku}")
	public boolean searchBySku(@PathVariable String sku)
	{
		return productService.existsBySku(sku);
	}
	
	@PutMapping(path="/api/product/{id}")
	public ResponseEntity<Product>  updateProduct(@PathVariable long id, @RequestBody Product product)
	{
		Product updated = proService.save(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping(path="api/product/{id}")
	public Optional<Product> findById(@PathVariable Long id)
	{
		return productService.findById(id);
	}
	
	
}
