package com.mulewebapi.mulewebapi.repository;

import com.mulewebapi.mulewebapi.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE p.productCode = ?1 OR p.unitPrice = ?2")
    Optional<Product> checkProductIsExist(String productCode, Double unitPrice);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (product_code, unit_price, product_name, unit, quantity_in_stock, created_by_date, created_by) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)",
            nativeQuery = true)
    void addProduct(String productCode,
                       Double unitPrice,
                       String productName,
                       String unit,
                       Double quantityInStock,
                       LocalDate createdByDate,
                       String createdBy);

    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET " +
            "quantity_in_stock = quantity_in_stock + ?2, " +
            "unit_price = (quantity_in_stock * unit_price + ?2 * ?3) / 2 " +
            "WHERE product_code = ?1",
            nativeQuery = true)
    void updateProductByPurchaseOrder(String productCode, Double quantity, Double purchasePrice);

    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET " +
            "quantity_in_stock = quantity_in_stock - ?2 " +
            "WHERE product_code = ?1",
            nativeQuery = true)
    void updateProductBySaleOrder(String productCode, Double quantity);
}
