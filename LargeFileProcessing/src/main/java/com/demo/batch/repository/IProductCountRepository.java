package com.demo.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.batch.entity.ProductCount;


@Repository
public interface IProductCountRepository extends JpaRepository<ProductCount, Long> {
	

}
