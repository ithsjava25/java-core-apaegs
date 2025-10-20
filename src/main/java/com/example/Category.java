package com.example;

import java.util.HashMap;
import java.util.Map;

//    Use a private constructor and a public static factory Category.of(String name).
//    Validate input: null => "Category name can't be null"; empty/blank => "Category name can't be blank".
//    Normalize name with initial capital letter (e.g., "fruit" -> "Fruit").
//    Cache/flyweight: return the same instance for the same normalized name.

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
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }

        // Empty check
        if (name.isBlank()) {
            throw new IllegalArgumentException("Category name can't be blank");
        }

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