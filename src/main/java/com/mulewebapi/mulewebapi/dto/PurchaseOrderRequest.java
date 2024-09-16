package com.mulewebapi.mulewebapi.dto;

import com.mulewebapi.mulewebapi.entity.PurchaseOrder;
import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderRequest {
    private PurchaseOrder purchaseOrder;
    private List<PurchaseOrderDetail> details;
}