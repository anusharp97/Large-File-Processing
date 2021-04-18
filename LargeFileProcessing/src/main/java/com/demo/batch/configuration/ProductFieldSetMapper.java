package com.demo.batch.configuration;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import com.demo.batch.entity.Product;

@Component
public class ProductFieldSetMapper implements FieldSetMapper<Product> {

    @Override
    public Product mapFieldSet(FieldSet fieldSet) {
        final Product product = new Product();

        product.setName(fieldSet.readString("name"));
        product.setSku(fieldSet.readString("sku"));
        product.setDescription(fieldSet.readString("description"));
        System.out.println(product.toString());
        return product;

    }
}
