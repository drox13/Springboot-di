package com.dario.springboot.di.app.sprinfboot_di.repositories;

import java.util.List;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
