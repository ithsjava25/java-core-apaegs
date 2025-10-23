package com.example;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, Category> cache = new HashMap<>();
    private final String name;

    // Private constructor
    private Category(String name) {
        this.name = name;
    }

    // Factory method
    public static Category of(String name) {
        // Null check
        if (name == null) { throw new IllegalArgumentException("Category name can't be null"); }
        // Empty check
        if (name.isBlank()) { throw new IllegalArgumentException("Category name can't be blank"); }
        // Normalize
        String normalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        // Flyweight pattern
        return cache.computeIfAbsent(normalized, Category::new);
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}