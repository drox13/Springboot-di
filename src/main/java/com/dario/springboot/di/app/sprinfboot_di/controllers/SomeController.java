package com.dario.springboot.di.app.sprinfboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;
import com.dario.springboot.di.app.sprinfboot_di.services.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    public List<Product> listProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return productService.findById(id);
    }
    
}
