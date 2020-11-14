package ru.pirozhkov.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository.getProduct(1).getName());
        CartService cartService = context.getBean("cartService", CartService.class);
        cartService.addProduct(1);
        cartService.addProduct(2);
        cartService.addProduct(4);
        cartService.deleteProduct(4);
        System.out.println(cartService.getSum());
        context.close();
    }






}
