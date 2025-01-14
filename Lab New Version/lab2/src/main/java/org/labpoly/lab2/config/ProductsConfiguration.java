package org.labpoly.lab2.config;

import org.labpoly.lab2.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductsConfiguration {
    @Bean
    @Scope("prototype")
    static public List<Product> products() {
        return new ArrayList<>();
    }
}
