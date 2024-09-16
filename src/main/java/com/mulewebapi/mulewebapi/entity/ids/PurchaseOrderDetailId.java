package com.mulewebapi.mulewebapi.entity.ids;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PurchaseOrderDetailId implements Serializable {
    private String orderNo;
    private String productCode;
    private Double purchasePrice;
}
