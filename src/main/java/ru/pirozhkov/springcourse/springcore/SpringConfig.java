package ru.pirozhkov.springcourse.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringConfig {

    @Bean
    public ProductRepository productRepository () {
        return new ProductRepository();
    }

    @Bean
    public List<Product> cart () {
        List<Product> cart = new ArrayList<>();
        return cart;
    }

    @Bean
    @Scope("prototype")
    public CartService cartService () {
        return new CartService(productRepository(), cart());
    }
}
