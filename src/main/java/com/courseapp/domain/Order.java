package com.courseapp.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDateTime dateOfPurchase;

    private BigDecimal price;

    public Order() {
    }

    public Order(Long orderId, LocalDateTime dateOfPurchase, BigDecimal price) {
        this.orderId = orderId;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
