package com.dario.springboot.di.app.sprinfboot_di.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;

@Primary
@SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "CPU inter Core i9", 850L),
            new Product(3L, "Teclado Razer mini",180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        //.orElseThrow();
    }
}