package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mulewebapi.mulewebapi.config.LocalDateDeserializer;
import com.mulewebapi.mulewebapi.config.LocalDateSerializer;
import com.mulewebapi.mulewebapi.entity.ids.PurchaseOrderId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "PurchaseOrders")
@IdClass(PurchaseOrderId.class)
public class PurchaseOrder {
    @Id
    private String orderNo;

    @Id
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;

    private String title;

    private String description;

    private LocalDate createdByDate;

    private String createdBy;

    @PrePersist
    protected void onCreate() {
        this.createdByDate = LocalDate.now();
        if (this.createdBy == null || this.createdBy.isEmpty()) {
            this.createdBy = "DatLHD1";
        }
    }
}