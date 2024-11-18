package com.dario.springboot.di.app.sprinfboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dario.springboot.di.app.sprinfboot_di.models.Product;
import com.dario.springboot.di.app.sprinfboot_di.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
    /* 
    asi seria el uso de  @Qualifier con el uso de  @Autowired()
    @Autowired()
    @Qualifier("productFoo")
     */
    private IProductRepository productRepository;
    
    public ProductServiceImpl(@Qualifier("productList") IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice()*1.25d;
            //Product productAux = new Product(p.getId(), p.getName(), priceImp.longValue());
            
            p.setPrice(priceTax.longValue());
            return p;
            
            /* 
            Product productAux = (Product) p.clone();
            productAux.setPrice(priceTax.longValue());
            return productAux;
            */
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }

}
