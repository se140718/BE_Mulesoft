package com.mulewebapi.mulewebapi.service;

import com.mulewebapi.mulewebapi.entity.PurchaseOrder;
import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.repository.ProductRepository;
import com.mulewebapi.mulewebapi.repository.PurchaseOrderDetailRepository;
import com.mulewebapi.mulewebapi.repository.PurchaseOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Transactional
    public void createPurchaseOrder(PurchaseOrder purchaseOrder, List<PurchaseOrderDetail> details) {
        // Save Purchase Order
        purchaseOrderRepository.save(purchaseOrder);

        // Save Purchase Order Details
        purchaseOrderDetailRepository.saveAll(details);

        // Update Products
        for (PurchaseOrderDetail detail : details) {
            productRepository.updateProductByPurchaseOrder(
                    detail.getProductCode(),
                    detail.getQuantity(),
                    detail.getPurchasePrice()
            );
        }
    }
}
