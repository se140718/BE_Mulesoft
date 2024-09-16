package com.mulewebapi.mulewebapi.entity.ids;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SaleOrderId implements Serializable {
    private String orderNo;
    private LocalDate orderDate;
}
