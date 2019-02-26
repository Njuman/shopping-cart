package com.equalexperts.cart;

import java.math.BigDecimal;

class CartCalculator {
    private Cart cart;

    /**
     *
     * @param cart instance of shopping cart
     */
    CartCalculator(Cart cart) {
        this.cart = cart;
    }

    /**
     *
     * @return BigDecimal
     */
    BigDecimal getTotal() {
        // used lambdas and filter methods here because the BigDecimal is immutable and it would have required to create a new variable
        // for everytime the value is mutated. Which would have been less cleaner.
        return cart.getItems().stream().map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }

    /**
     *
     * @return BigDecimal
     */
    BigDecimal getTotalIncludingTax() {
        return getTotal().multiply(new BigDecimal("1.125")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     *
     * @return BigDecimal
     */
    BigDecimal getTaxRate() {
        return getTotal().multiply(new BigDecimal("0.125")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
