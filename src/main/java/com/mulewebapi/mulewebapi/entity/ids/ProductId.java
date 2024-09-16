package com.mulewebapi.mulewebapi.entity.ids;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductId implements Serializable {
    private String productCode;
    private Double unitPrice;
}
