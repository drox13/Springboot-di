package com.dario.springboot.di.app.sprinfboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.dario.springboot.di.app.sprinfboot_di.repositories.IProductRepository;
import com.dario.springboot.di.app.sprinfboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
