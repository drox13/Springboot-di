package com.dario.springboot.di.app.sprinfboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;
import com.dario.springboot.di.app.sprinfboot_di.repositories.ProductRepositoryImpl;

@Component
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepositoryImpl productRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice()*1.25d;
            //Product productAux = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product productAux = (Product) p.clone();
            productAux.setPrice(priceTax.longValue());
            return productAux;
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }
}