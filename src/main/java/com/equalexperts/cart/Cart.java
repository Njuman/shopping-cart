package com.equalexperts.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Cart {

    private List<Product> items = new ArrayList<>();

    /**
     *
     * @param product instance of product to be added to cart.
     */
    void add(Product product) {
        items.add(product);
    }

    /**
     *
     * @return List<Product>
     */
    List<Product> getItems() {
        return items;
    }

    /**
     *
     * @param name The name of the product that will be used as check for the filter.
     * @return List<Product>
     */
    List<Product> getItemsByName(String name) {
        return items.stream().filter(item -> name.equals(item.getName())).collect(Collectors.toList());
    }
}
