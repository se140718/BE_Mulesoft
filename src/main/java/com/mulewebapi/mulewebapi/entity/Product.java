package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "Products")
public class Product {
    @Id
    private String productCode;

    private String productName;

    private String unit;

    private Double quantityInStock;

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