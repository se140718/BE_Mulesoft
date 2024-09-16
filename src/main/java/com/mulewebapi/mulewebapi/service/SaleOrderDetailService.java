package com.mulewebapi.mulewebapi.service;

import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import com.mulewebapi.mulewebapi.repository.SaleOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
SaleOrderDetailService {

    private final SaleOrderDetailRepository saleOrderDetailRepository;

    @Autowired
    public SaleOrderDetailService(SaleOrderDetailRepository saleOrderDetailRepository) {
        this.saleOrderDetailRepository = saleOrderDetailRepository;
    }

    public List<SaleOrderDetail> getSaleOrderDetails() {
        return saleOrderDetailRepository.findAll();
    }

    public void addSaleOrderDetail(SaleOrderDetail saleOrderDetail) {
        Optional<SaleOrderDetail> checkSaleOrderDetail = saleOrderDetailRepository.checkSaleOrderIsExist(saleOrderDetail.getOrderNo(), saleOrderDetail.getProductCode(), saleOrderDetail.getSalePrice());
        if (checkSaleOrderDetail.isPresent()) {
            throw new IllegalStateException("Sale Order Detail already exists");
        }

        saleOrderDetailRepository.addSaleOrderDetail(
                saleOrderDetail.getOrderNo(),
                saleOrderDetail.getProductCode(),
                saleOrderDetail.getQuantity(),
                saleOrderDetail.getSalePrice(),
                saleOrderDetail.getTax()
        );
    }
}
