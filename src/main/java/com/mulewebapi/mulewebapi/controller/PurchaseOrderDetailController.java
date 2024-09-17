package com.mulewebapi.mulewebapi.controller;

import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.service.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/purchase-order-details")
public class PurchaseOrderDetailController {
    private final PurchaseOrderDetailService purchaseOrderDetailService;

    @Autowired
    public PurchaseOrderDetailController(PurchaseOrderDetailService purchaseOrderDetailService) {
        this.purchaseOrderDetailService = purchaseOrderDetailService;
    }

    @GetMapping
    public List<PurchaseOrderDetail> getAllPurchaseOrders() {
        return purchaseOrderDetailService.getPurchaseOrderDetails();
    }
}
