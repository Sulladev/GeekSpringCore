package ru.pirozhkov.springcourse;

import ru.pirozhkov.Product;


import java.util.Iterator;
import java.util.List;


public class CartService {

    private ProductRepository productRepository;
    private List <Product> cart;

    public CartService(ProductRepository productRepository, List<Product> cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void addProduct (int id) {
        cart.add(productRepository.getProduct(id));
    }

    public void deleteProduct (int id) {
        cart.remove(productRepository.getProduct(id));
    }

    public double getSum () {
       double sum = 0;
        for (Product p: cart) {
            sum += p.getPrice();
        }
        return  sum;
    }
}
