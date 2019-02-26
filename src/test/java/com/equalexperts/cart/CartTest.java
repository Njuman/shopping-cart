package com.equalexperts.cart;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    private static Product doveSoap;

    private static Product axeDeo;

    @BeforeClass
    public static void beforeClass() {
        doveSoap = new Product(
                "Dove Soap",
                BigDecimal.valueOf(39.99)
        );

        axeDeo = new Product(
                "Axe Deo",
                BigDecimal.valueOf(99.99)
        );
    }

    @Test
    public void addProductToCart() {
        Cart cart = new Cart();

        for (int i = 0; i < 5; i++) {
            cart.add(doveSoap);
        }

        CartCalculator cartCalculator = new CartCalculator(cart);

        assertEquals("Shopping Cart should contain 5 Products", 5, cart.getItems().size());
        assertEquals("Shopping Cart total should equal 199.95", BigDecimal.valueOf(199.95), cartCalculator.getTotal());
    }

    @Test
    public void addAdditionalProductOfSameTypeToCart() {
        Cart cart = new Cart();

        for (int i = 0; i < 5; i++) {
            cart.add(doveSoap);
        }

        for (int i = 0; i < 3; i++) {
            cart.add(doveSoap);
        }

        CartCalculator cartCalculator = new CartCalculator(cart);

        assertEquals("Shopping Cart should contain 8 Products",8, cart.getItems().size());
        assertEquals("Shopping Cart total should equal 319.92", BigDecimal.valueOf(319.92), cartCalculator.getTotal());
    }

    @Test
    public void addMultipleItemsToCart() {
        Cart cart = new Cart();

        for (int i = 0; i < 2; i++) {
            cart.add(doveSoap);
            cart.add(axeDeo);
        }

        assertEquals("Shopping cart should contain 2 Dove Soaps",2, cart.getItemsByName("Dove Soap").size());
        assertEquals("Shopping cart should contain 2 Axe Deo",2, cart.getItemsByName("Axe Deo").size());
    }

    @Test
    public void calculateTaxRateOfCartWithMultipleItems() {
        Cart cart = new Cart();

        for (int i = 0; i < 2; i++) {
            cart.add(doveSoap);
            cart.add(axeDeo);
        }

        CartCalculator cartCalculator = new CartCalculator(cart);

        assertEquals("Shopping cart sale tax should equal 35.00", BigDecimal.valueOf(35.00).setScale(2), cartCalculator.getTaxRate());
        assertEquals("Shopping cart total inc tax should equal 314.96", BigDecimal.valueOf(314.96), cartCalculator.getTotalIncludingTax());
    }
}