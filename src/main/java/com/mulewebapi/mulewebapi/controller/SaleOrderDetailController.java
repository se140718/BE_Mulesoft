package com.mulewebapi.mulewebapi.controller;

import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import com.mulewebapi.mulewebapi.service.SaleOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sale-order-details")
public class SaleOrderDetailController {
    private final SaleOrderDetailService saleOrderDetailService;

    @Autowired
    public SaleOrderDetailController(SaleOrderDetailService saleOrderDetailService) {
        this.saleOrderDetailService = saleOrderDetailService;
    }

    @GetMapping
    public List<SaleOrderDetail> getAllPurchaseOrders() {
        return saleOrderDetailService.getSaleOrderDetails();
    }
}
