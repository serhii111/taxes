package com.example.taxes.service;

import com.example.taxes.dto.Invoice;
import com.example.taxes.dto.Product;
import com.example.taxes.dto.Total;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{
    @Value("${tax}")
    private BigDecimal tax;

    public Invoice prepareInvoice(List<Product> products) {

        List<Product> taxedProducts = new ArrayList<>();

        BigDecimal priceTotal = BigDecimal.ZERO;
        BigDecimal taxTotal = BigDecimal.ZERO;
        BigDecimal amountTotal = BigDecimal.ZERO;

        for (Product product: products) {
            BigDecimal price = product.getPrice();
            priceTotal = priceTotal.add(price);


            BigDecimal total = price.add(tax);
            product.setTotal(total);

            taxTotal = taxTotal.add(tax);
            product.setTax(tax);

            amountTotal = amountTotal.add(total);

            taxedProducts.add(product);
        }

        Total invoiceTotal = Total.builder()
                .price(priceTotal)
                .tax(taxTotal)
                .totalAmount(amountTotal)
                .build();


        return Invoice.builder()
                .products(taxedProducts)
                .total(invoiceTotal)
                .build();
    }
}
