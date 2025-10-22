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
    private final BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);

        if (warrantyMonths < 0) { throw new IllegalArgumentException("Warranty months cannot be negative."); }
        if (price.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Price cannot be negative."); }
        if (weight.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Weight cannot be negative."); }

        this.warrantyMonths = warrantyMonths;
        this.weight = weight;

    }

    public int warrantyMonths() {
        return this.warrantyMonths;
    }

    @Override
    String productDetails() {
        return "Electronics: " + name() + ", Warranty: " + warrantyMonths() + " months";
    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal cost = BigDecimal.valueOf(79);
        if (weight.compareTo(BigDecimal.valueOf(5.0)) > 0) {
            cost = cost.add(BigDecimal.valueOf(49));
        }
        return cost;
    }

    @Override
    public double weight() {
        return this.weight.doubleValue(); // Konvertera BigDecimal till double
    }
}
