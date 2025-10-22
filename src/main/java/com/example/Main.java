package com.example;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = Warehouse.getInstance("Test Warehouse");

        System.out.println(warehouse.name());

    }
}
