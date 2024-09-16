package com.mulewebapi.mulewebapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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

    private Date createdByDate;

    private String createdBy;
}