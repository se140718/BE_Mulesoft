package com.mulewebapi.mulewebapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mulewebapi.mulewebapi.config.LocalDateDeserializer;
import com.mulewebapi.mulewebapi.config.LocalDateSerializer;
import com.mulewebapi.mulewebapi.entity.ids.SaleOrderId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "SaleOrders")
@IdClass(SaleOrderId.class)
public class SaleOrder {
    @Id
    private String orderNo;

    @Id
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate orderDate;

    private String title;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdByDate;

    private String createdBy;
}