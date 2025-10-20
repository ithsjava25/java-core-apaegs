package com.example;

//    Implements Shippable.
//    Fields: int warrantyMonths, BigDecimal weight (kg).
//    Validation: negative warranty -> IllegalArgumentException("Warranty months cannot be negative.").
//    productDetails() should look like: "Electronics: Laptop, Warranty: 24 months".
//    Shipping rule: base 79, add 49 if weight > 5.0 kg.

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable{

    private int warrantyMonths;
    private BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;

        if (this.warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (weight.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
    }

    public int warrantyMonths() {
        return warrantyMonths;
    }

    @Override
    String productDetails() {
        return "Electronics: " + name() + ", Warranty: " + warrantyMonths() + " months";
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return null;
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
