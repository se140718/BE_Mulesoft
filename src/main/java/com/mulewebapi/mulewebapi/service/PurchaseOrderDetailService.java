package com.mulewebapi.mulewebapi.service;

import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.repository.PurchaseOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
PurchaseOrderDetailService {

    private final PurchaseOrderDetailRepository purchaseOrderDetailRepository;

    @Autowired
    public PurchaseOrderDetailService(PurchaseOrderDetailRepository purchaseOrderDetailRepository) {
        this.purchaseOrderDetailRepository = purchaseOrderDetailRepository;
    }

    public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return purchaseOrderDetailRepository.findAll();
    }
}
