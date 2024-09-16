package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdByDate;

    private String createdBy;
}