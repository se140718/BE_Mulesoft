package com.mulewebapi.mulewebapi.controller;

import com.mulewebapi.mulewebapi.dto.PurchaseOrderRequest;
import com.mulewebapi.mulewebapi.dto.SaleOrderRequest;
import com.mulewebapi.mulewebapi.entity.SaleOrder;
import com.mulewebapi.mulewebapi.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sale-orders")
public class SaleOrderController {
    private final SaleOrderService saleOrderService;

    @Autowired
    public SaleOrderController(SaleOrderService saleOrderService) {
        this.saleOrderService = saleOrderService;
    }

    @GetMapping
    public List<SaleOrder> getAllSaleOrders() {
        return saleOrderService.getSaleOrders();
    }

    @PostMapping()
    public ResponseEntity<String> createSaleOrder(
            @RequestBody SaleOrderRequest request) {

        saleOrderService.createSaleOrder(request.getSaleOrder(), request.getDetails());
        return ResponseEntity.ok("Sale order created successfully");
    }
}
