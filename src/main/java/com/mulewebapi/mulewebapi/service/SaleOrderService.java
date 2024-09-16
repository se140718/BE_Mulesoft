package com.mulewebapi.mulewebapi.service;

import com.mulewebapi.mulewebapi.entity.PurchaseOrder;
import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.entity.SaleOrder;
import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import com.mulewebapi.mulewebapi.repository.ProductRepository;
import com.mulewebapi.mulewebapi.repository.SaleOrderDetailRepository;
import com.mulewebapi.mulewebapi.repository.SaleOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
SaleOrderService {

    private final SaleOrderRepository saleOrderRepository;

    @Autowired
    private SaleOrderDetailRepository saleOrderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public SaleOrderService(SaleOrderRepository saleOrderRepository) {
        this.saleOrderRepository = saleOrderRepository;
    }

    public List<SaleOrder> getSaleOrders() {
        return saleOrderRepository.findAll();
    }

    @Transactional
    public void createSaleOrder(SaleOrder saleOrder, List<SaleOrderDetail> details) {
        // Save Purchase Order
        saleOrderRepository.save(saleOrder);

        // Save Purchase Order Details
        saleOrderDetailRepository.saveAll(details);

        // Update Products
        for (SaleOrderDetail detail : details) {
            productRepository.updateProductBySaleOrder(
                    detail.getProductCode(),
                    detail.getQuantity()
            );
        }
    }
}
