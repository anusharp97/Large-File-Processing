package com.demo.batch.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.batch.entity.Product;
import com.demo.batch.entity.ProductCount;
import com.demo.batch.repository.IProductCountRepository;
import com.demo.batch.repository.IProductRepository;

@Component
public class NotificationListener extends JobExecutionListenerSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IProductRepository productService;
	
	@Autowired
	private IProductCountRepository prodCount;

	@Autowired
	public NotificationListener(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(final JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOGGER.info("!!! JOB FINISHED! Time to verify the results");

			//below lines can be uncommented to see the time taken
//			jdbcTemplate.query("SELECT name, sku, description FROM product",
//							(rs, row) -> new Product(rs.getString("name"), rs.getString("sku"), rs.getString("description")))
//					.forEach(product -> LOGGER.info("Found <" + product + "> in the database."));
			
			
			
			//Running an aggregated query to give no. of products with the same name
			
			List<Object[]> res = productService.getCountByName();
			
			for (Object[] ob : res){
			    String name = (String)ob[0];
			    Long noOfProducts = (Long)ob[1];
			    ProductCount newProd = new ProductCount(name,noOfProducts);
			    prodCount.save(newProd);
			    
			}
			
		}
	}
}
