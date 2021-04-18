package com.demo.batch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.batch.entity.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	
	@Query("select p.name,count(p.sku) from Product as p group by p.name")
	public List<Object[]> getCountByName();
	
	@Query(value="select id,name,sku,description from Product where sku= :sku",nativeQuery=true)
	public List<Product> findProductsBySku(String sku);
	
	@Query(value="select id,name,sku,description from Product", nativeQuery=true)
	public List<Product> findAll();
	
	public boolean existsBySku(String sku);
	
	public Optional<Product> findById(Long id);

}
