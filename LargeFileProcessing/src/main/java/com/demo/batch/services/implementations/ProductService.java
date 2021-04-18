package com.demo.batch.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.batch.entity.Product;
import com.demo.batch.repository.IProductRepository;
import com.demo.batch.services.interfaces.IProductService;

@Service
public class ProductService implements IProductService
{

	@Autowired
	private IProductRepository productService;
	
	@Override
	public List<Product> findProductsBySku(String sku) {
		try {
			return productService.findProductsBySku(sku);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while fetching records for sku: "+sku);
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		try {
			return productService.findAll();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while fetching all records");
		}
		return null;
	}


	@Override
	public boolean existsBySku(String sku) {
		// TODO Auto-generated method stub
		return productService.existsBySku(sku);
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productService.findById(id);
	}


}
