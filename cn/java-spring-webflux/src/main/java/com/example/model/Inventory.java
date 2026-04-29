package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Inventory {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Integer lockedQuantity;
    private BigDecimal costPrice;
    private String warehouse;
    private LocalDateTime lastStockIn;
    private LocalDateTime lastStockOut;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getLockedQuantity() { return lockedQuantity; }
    public void setLockedQuantity(Integer lockedQuantity) { this.lockedQuantity = lockedQuantity; }
    public BigDecimal getCostPrice() { return costPrice; }
    public void setCostPrice(BigDecimal costPrice) { this.costPrice = costPrice; }
    public String getWarehouse() { return warehouse; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }
    public LocalDateTime getLastStockIn() { return lastStockIn; }
    public void setLastStockIn(LocalDateTime lastStockIn) { this.lastStockIn = lastStockIn; }
    public LocalDateTime getLastStockOut() { return lastStockOut; }
    public void setLastStockOut(LocalDateTime lastStockOut) { this.lastStockOut = lastStockOut; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
