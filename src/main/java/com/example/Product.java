package com.example;

import java.math.BigDecimal;
import java.util.UUID;

//    Keep UUID id, String name, Category category, BigDecimal price.
//    Provide getters named uuid(), name(), category(), price() and a setter price(BigDecimal).
//    Provide an abstract String productDetails() for polymorphism.

public abstract class Product {

    private final UUID id;
    private final String name;
    private final Category category;
    private BigDecimal price;

    public Product(UUID id, String name, Category category, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    abstract String productDetails();

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID uuid() {
        return id;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }
}
