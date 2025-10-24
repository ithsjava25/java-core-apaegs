package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product implements Perishable, Shippable{

    private LocalDate expirationDate;
    private BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        super(id, name, category, price);

        // Price check
        if (price.compareTo(java.math.BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Price cannot be negative.");
        // Weight check
        if (weight.compareTo(BigDecimal.ZERO) < 0)  throw new IllegalArgumentException("Weight cannot be negative.");

        this.expirationDate = expirationDate;
        this.weight = weight;
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
        return this.weight.doubleValue();
    }
}
