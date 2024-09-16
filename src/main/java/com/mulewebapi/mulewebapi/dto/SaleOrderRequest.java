package com.mulewebapi.mulewebapi.dto;

import com.mulewebapi.mulewebapi.entity.SaleOrder;
import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import com.mulewebapi.mulewebapi.entity.SaleOrder;
import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class SaleOrderRequest {
    private SaleOrder saleOrder;
    private List<SaleOrderDetail> details;
}
