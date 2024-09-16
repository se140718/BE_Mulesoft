package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mulewebapi.mulewebapi.entity.ids.SaleOrderDetailId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SaleOrderDetails")
@IdClass(SaleOrderDetailId.class)
public class SaleOrderDetail {
    @Id
    private String orderNo;

    @Id
    private String productCode;

    private Double quantity;

    private Double salePrice;

    private Double tax;
}