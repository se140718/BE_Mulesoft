package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mulewebapi.mulewebapi.entity.ids.ProductId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "Products")
@IdClass(ProductId.class)
public class Product {
    @Id
    private String productCode;

    private String productName;

    private String unit;

    private Double quantityInStock;

    @Id
    private Double unitPrice;

    private LocalDate createdByDate;

    private String createdBy;

    @PrePersist
    protected void onCreate() {
        this.createdByDate = LocalDate.now();
        if (this.createdBy == null || this.createdBy.isEmpty()) {
            this.createdBy = "DatLHD1";
        }
    }
}


