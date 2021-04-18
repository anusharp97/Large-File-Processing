package com.demo.batch.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.demo.batch.entity.Product;

public class ProductProcessor implements ItemProcessor<Product, Product>{

    @Override
    public Product process(final Product product) {
        final String name= product.getName();
        final String sku= product.getSku();
        final String desc = product.getDescription();

        final Product processedProduct = new Product();
        processedProduct.setName(name);
        processedProduct.setSku(sku);
        processedProduct.setDescription(desc);
        return processedProduct;
    }
}
