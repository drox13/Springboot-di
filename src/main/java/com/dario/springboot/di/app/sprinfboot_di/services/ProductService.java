package com.dario.springboot.di.app.sprinfboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;
import com.dario.springboot.di.app.sprinfboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice()*1.25d;
            Product productAux = new Product(p.getId(), p.getName(), priceImp.longValue());
            return productAux;
        }).collect(Collectors.toList());
    }
    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
