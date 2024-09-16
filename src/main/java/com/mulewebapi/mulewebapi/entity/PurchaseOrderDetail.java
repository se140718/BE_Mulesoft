package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mulewebapi.mulewebapi.entity.ids.PurchaseOrderDetailId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PurchaseOrderDetails")
@IdClass(PurchaseOrderDetailId.class)
public class PurchaseOrderDetail {
    @Id
    private String orderNo;

    @Id
    private String productCode;

    private Double quantity;

    private Double purchasePrice;

    private Double tax;
}