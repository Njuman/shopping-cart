package com.equalexperts.cart;

import java.math.BigDecimal;

class Product {

    private String name;

    private BigDecimal price;

    /**
     *
     * @param name name of product
     * @param price value of product
     */
    Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @return String
     */
    String getName() {
        return name;
    }

    /**
     *
     * @return BigDecimal
     */
    BigDecimal getPrice() {
        return price;
    }
}
