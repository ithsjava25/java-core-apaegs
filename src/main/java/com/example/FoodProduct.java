package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

//    Implements Perishable and Shippable.
//    Fields: LocalDate expirationDate, BigDecimal weight (kg).
//    Validations: negative price -> IllegalArgumentException("Price cannot be negative.");
//    negative weight -> IllegalArgumentException("Weight cannot be negative.").
//    productDetails() should look like: "Food: Milk, Expires: 2025-12-24".
//    Shipping rule: cost = weight * 50.


public class FoodProduct extends Product implements Perishable, Shippable{


    LocalDate expirationDate;
    BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        super(id, name, category, price);

        if (price.compareTo(java.math.BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Price cannot be negative."); }
        if (weight.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Weight cannot be negative."); }

        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return Perishable.super.isExpired();
    }

    @Override
    public String productDetails() {
        return "Food: " + name() + ", Expires: " + expirationDate();
    }

    @Override
    public LocalDate expirationDate() {
        return this.expirationDate;
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return weight.multiply(BigDecimal.valueOf(50));
    }

    @Override
    public double weight() {
        return this.weight.doubleValue(); // Konvertera BigDecimal till double
    }
}
