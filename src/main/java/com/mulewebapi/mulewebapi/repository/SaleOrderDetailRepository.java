package com.mulewebapi.mulewebapi.repository;

import com.mulewebapi.mulewebapi.entity.SaleOrderDetail;
import com.mulewebapi.mulewebapi.entity.ids.SaleOrderDetailId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleOrderDetailRepository extends JpaRepository<SaleOrderDetail, SaleOrderDetailId> {
    @Query("SELECT o FROM SaleOrderDetail o WHERE o.orderNo = ?1 OR o.productCode = ?2 OR o.salePrice = ?3")
    Optional<SaleOrderDetail> checkSaleOrderIsExist(String orderNo, String productCode, Double salePrice);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SaleOrderDetails (OrderNo, ProductCode, Quantity, SalePrice, Tax) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)",
            nativeQuery = true)
    void addSaleOrderDetail(String orderNo,
                            String productCode,
                            Double quantity,
                            Double salePrice,
                            Double tax);
}
