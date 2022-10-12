package com.example.taxes.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private String productName;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal total;
}
