package com.dario.springboot.di.app.sprinfboot_di.services;

import java.util.List;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
