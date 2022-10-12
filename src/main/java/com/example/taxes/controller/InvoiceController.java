package com.example.taxes.controller;

import com.example.taxes.dto.Invoice;

import com.example.taxes.dto.Product;
import com.example.taxes.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping(value = "/invoice", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Invoice getInvoice(@RequestBody List<Product> products) {
        return invoiceService.prepareInvoice(products);
    }
}
