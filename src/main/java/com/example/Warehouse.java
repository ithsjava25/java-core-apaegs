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

public class Warehouse {


    public void addProduct() {}
    public Product getProducts() {
        Product Product = null;
        return Product; }
    public Product getProductById(Product product) {
        Product Product = null;
        return Product; }
    public void updateProductPrice() {}
    public void expiredProducts() {}
    public void shippableProducts() {}
    public void remove() {}
}
