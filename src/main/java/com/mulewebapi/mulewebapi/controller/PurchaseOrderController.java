package com.mulewebapi.mulewebapi.controller;

import com.mulewebapi.mulewebapi.dto.PurchaseOrderRequest;
import com.mulewebapi.mulewebapi.entity.PurchaseOrder;
import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/purchase-orders")
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getPurchaseOrders();
    }

    @PostMapping()
    public ResponseEntity<String> createPurchaseOrder(
            @RequestBody PurchaseOrderRequest request) {

        purchaseOrderService.createPurchaseOrder(request.getPurchaseOrder(), request.getDetails());
        return ResponseEntity.ok("Purchase order created successfully");
    }
}
