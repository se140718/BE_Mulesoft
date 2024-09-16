package com.mulewebapi.mulewebapi.repository;

import com.mulewebapi.mulewebapi.entity.SaleOrder;
import com.mulewebapi.mulewebapi.entity.ids.SaleOrderId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, SaleOrderId> {
    @Query("SELECT p FROM SaleOrder p WHERE p.orderNo = ?1 OR p.orderDate = ?2")
    Optional<SaleOrder> checkSaleOrderIsExist(String orderNo, LocalDate orderDate);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SaleOrder (OrderNo, OrderDate, Title, Description, CreatedByDate, CreatedBy) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void addSaleOrder(String orderNo,
                      LocalDate orderDate,
                      String title,
                      String description,
                      LocalDate createdByDate,
                      String createdBy);
}
