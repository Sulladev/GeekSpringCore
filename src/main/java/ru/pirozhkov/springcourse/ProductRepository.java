package ru.pirozhkov.springcourse;

import ru.pirozhkov.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList;
    private static int PRODUCT_COUNT;

    {
        productList = new ArrayList<>();

        productList.add( new Product(++PRODUCT_COUNT, "Mavic", 1200));
        productList.add( new Product(++PRODUCT_COUNT, "Phantom", 1400));
        productList.add( new Product(++PRODUCT_COUNT, "Inspire", 2200));
        productList.add( new Product(++PRODUCT_COUNT, "Matrice", 4500));
        productList.add( new Product(++PRODUCT_COUNT, "Autel", 1700));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct (int id) {
        return productList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

}
