package com.mulewebapi.mulewebapi.repository;

import com.mulewebapi.mulewebapi.entity.PurchaseOrderDetail;
import com.mulewebapi.mulewebapi.entity.ids.PurchaseOrderDetailId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, PurchaseOrderDetailId> {
    @Query("SELECT o FROM PurchaseOrderDetail o WHERE o.orderNo = ?1 OR o.productCode = ?2 OR o.purchasePrice = ?3")
    Optional<PurchaseOrderDetail> checkPurchaseOrderIsExist(String orderNo, String productCode, Double purchasePrice);
}
