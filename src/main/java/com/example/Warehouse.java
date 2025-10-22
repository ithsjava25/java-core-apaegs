package com.example;


//    getInstance(String name) returns the same instance per unique name.
//    addProduct(Product): throw IllegalArgumentException("Product cannot be null.") if null.
//    getProducts(): return an unmodifiable copy.
//    getProductById(UUID): return Optional.
//    updateProductPrice(UUID, BigDecimal): when not found,
//    throw NoSuchElementException("Product not found with id: ").
//    Also track changed products in getChangedProducts().
//    expiredProducts(): return List that are expired.
//    shippableProducts(): return List from stored products.
//    remove(UUID): remove the matching product if present.

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {

    // Static för singleton pattern
//    private static Map<String, Warehouse> instances = new HashMap<>();

    private static Warehouse instance; // en global instans

    // Instance fields
    private String name;
    private Map<UUID, Product> products = new HashMap<>();
    private Map<UUID, Product> instances = new HashMap<>();
    private Set<Product> changedProducts = new HashSet<>();

    // Singleton
    private Warehouse(String name) {
        this.name = name;
    }

    // Factory
    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse("name");
        }
        return instance;
    }

    public void clearProducts() {
        products.clear();
        changedProducts.clear();
    }
    public boolean isEmpty() {
        if (products == null) {
            return false;
        }
        return true;
    }

    public void addProduct(Product product){
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        products.put(product.uuid(), product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(new ArrayList<>(products.values()));
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }


    public void updateProductPrice(UUID uuid, BigDecimal newPrice) {}

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
                .toList();
    }

    public void remove(UUID uuid) {
        products.remove(uuid);
    }

    public Map<Category, List<Product>> getProductsGroupedByCategories() {
        if (products.isEmpty()) {
            return new HashMap<>();
        }

        return products.values().stream()
                .collect(Collectors.groupingBy(Product::category));
    }

}
