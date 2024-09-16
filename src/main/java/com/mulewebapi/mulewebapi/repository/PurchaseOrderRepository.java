package com.mulewebapi.mulewebapi.repository;

import com.mulewebapi.mulewebapi.entity.PurchaseOrder;
import com.mulewebapi.mulewebapi.entity.ids.PurchaseOrderId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, PurchaseOrderId> {
    @Query("SELECT p FROM PurchaseOrder p WHERE p.orderNo = ?1 OR p.orderDate = ?2")
    Optional<PurchaseOrder> checkPurchaseOrderIsExist(String orderNo, LocalDate orderDate);
}
