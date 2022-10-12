package com.example.taxes.service;

import com.example.taxes.dto.Invoice;
import com.example.taxes.dto.Product;

import java.util.List;

public interface InvoiceService {
    Invoice prepareInvoice(List<Product> products);
}
