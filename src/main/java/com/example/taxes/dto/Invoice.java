package com.example.taxes.dto;

import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class Invoice {
    private List<Product> products;
    private Total total;
}
