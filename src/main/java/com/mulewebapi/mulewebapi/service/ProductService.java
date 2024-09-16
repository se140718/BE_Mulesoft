package com.mulewebapi.mulewebapi.service;

import com.mulewebapi.mulewebapi.entity.Product;
import com.mulewebapi.mulewebapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> checkProduct = productRepository.checkProductIsExist(product.getProductCode(), product.getUnitPrice());
        if (checkProduct.isPresent()) {
            throw new IllegalStateException("Product already exists");
        }

        // Manually set createdByDate and createdBy if null
        if (product.getCreatedByDate() == null) {
            product.setCreatedByDate(LocalDate.now());
        }
        if (product.getCreatedBy() == null || product.getCreatedBy().isEmpty()) {
            product.setCreatedBy("DatLHD1");
        }

        productRepository.addProduct(product.getProductCode(),
                product.getUnitPrice(),
                product.getProductName(),
                product.getUnit(),
                product.getQuantityInStock(),
                product.getCreatedByDate(),
                product.getCreatedBy());
    }
}
