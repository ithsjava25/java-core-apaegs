package com.example;

import java.time.LocalDate;

public interface Perishable {
    // Metod som måste implementeras av klasser som använder detta interface
    LocalDate expirationDate();

    // Default metod - färdig implementation som alla kan använda
    default boolean isExpired() {
        return expirationDate().isBefore(LocalDate.now());
    }
}