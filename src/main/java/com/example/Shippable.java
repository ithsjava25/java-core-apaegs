package com.example;

import java.math.BigDecimal;

public interface Shippable {
    // Beräkna fraktkostnad
    BigDecimal calculateShippingCost();

    // Returnera vikt (som double)
    double weight();
}