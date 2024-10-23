package com.dario.springboot.di.app.sprinfboot_di.repositories;

import java.util.List;
import java.util.Arrays;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Mmoria corsair 32", 300L),
            new Product(2L, "CPU inter Core i9", 850L),
            new Product(3L, "Teclado Razer mini",180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return data;
    }
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        //.orElseThrow();
    }
}