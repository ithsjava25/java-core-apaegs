package com.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {

    private static Warehouse instance;

    private String name;
    private Map<UUID, Product> products = new HashMap<>();
    private Set<Product> changedProducts = new HashSet<>();

    // Singleton
    private Warehouse(String name) {
        this.name = name;
    }


    // Factory
    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse("Kata");
        }
        return instance;
    }

    public String name() { return name; }

    public void clearProducts() {
        products.clear();
        changedProducts.clear();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product) {
        if (product == null) { throw new IllegalArgumentException("Product cannot be null."); }
        if (products.containsKey(product.uuid()))
            { throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates."); }

        products.put(product.uuid(), product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(new ArrayList<>(products.values()));
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    public void updateProductPrice(UUID uuid, BigDecimal newPrice) {
        if (products.get(uuid) == null)  { throw new NoSuchElementException("Product not found with id: " + uuid); }
        products.get(uuid).setPrice(newPrice);
        changedProducts.add(products.get(uuid));

    }

    public List<Perishable> expiredProducts() {
        return products.values().stream()
                .filter(p -> p instanceof Perishable)
                .map(p -> (Perishable) p)
                .filter(p -> p.isExpired())
                .toList();
    }

    public List<Shippable> shippableProducts() {
        return products.values().stream()
                .filter(p -> p instanceof Shippable)
                .map(p -> (Shippable) p)
                .collect(Collectors.toList());
    }

    public void remove(UUID uuid) {
        products.remove(uuid);
    }

    public Map<Category, List<Product>> getProductsGroupedByCategories() {
        if (products.isEmpty()) { return new HashMap<>(); }
        return products.values().stream()
                .collect(Collectors.groupingBy(Product::category));
    }

}
