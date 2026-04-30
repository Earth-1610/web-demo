package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Inventory;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.math.BigDecimal;
import java.util.List;

public interface InventoryClient {
    
    @RequestLine("GET /api/inventory?productId={productId}&warehouse={warehouse}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Inventory>> listInventory(
            @Param("productId") Long productId,
            @Param("warehouse") String warehouse,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/inventory/{id}")
    Result<Inventory> getInventory(@Param("id") Long id);
    
    @RequestLine("GET /api/inventory/product/{productId}")
    Result<Inventory> getInventoryByProduct(@Param("productId") Long productId);
    
    @RequestLine("PUT /api/inventory/{id}?quantity={quantity}")
    Result<Inventory> updateInventory(@Param("id") Long id, @Param("quantity") Integer quantity);
    
    @RequestLine("POST /api/inventory/{id}/stock-in?quantity={quantity}&costPrice={costPrice}&warehouse={warehouse}")
    Result<Inventory> stockIn(
            @Param("id") Long id,
            @Param("quantity") Integer quantity,
            @Param("costPrice") BigDecimal costPrice,
            @Param("warehouse") String warehouse);
    
    @RequestLine("POST /api/inventory/{id}/stock-out?quantity={quantity}&warehouse={warehouse}")
    Result<Inventory> stockOut(
            @Param("id") Long id,
            @Param("quantity") Integer quantity,
            @Param("warehouse") String warehouse);
    
    @RequestLine("POST /api/inventory/{id}/check?requiredQuantity={requiredQuantity}")
    Result<InventoryCheckVO> checkStock(@Param("id") Long id, @Param("requiredQuantity") Integer requiredQuantity);
    
    @RequestLine("GET /api/inventory/{id}/history?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<InventoryHistoryVO>> getHistory(
            @Param("id") Long id,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/inventory/low-stock?threshold={threshold}")
    Result<List<Inventory>> getLowStockProducts(@Param("threshold") Integer threshold);
    
    @RequestLine("GET /api/inventory/out-of-stock")
    Result<List<Inventory>> getOutOfStockProducts();
    
    @RequestLine("POST /api/inventory/batch-stock-in")
    Result<List<Inventory>> batchStockIn(List<StockInReq> reqs);
    
    @RequestLine("POST /api/inventory/batch-stock-out")
    Result<List<Inventory>> batchStockOut(List<StockOutReq> reqs);
    
    @RequestLine("GET /api/inventory/statistics")
    Result<InventoryStatisticsVO> getStatistics();
    
    @RequestLine("GET /api/inventory/warehouse/{warehouse}?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Inventory>> getByWarehouse(
            @Param("warehouse") String warehouse,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/inventory/warehouses")
    Result<List<String>> getWarehouses();
    
    @RequestLine("POST /api/inventory/{id}/lock?quantity={quantity}")
    Result<Inventory> lockStock(@Param("id") Long id, @Param("quantity") Integer quantity);
    
    @RequestLine("POST /api/inventory/{id}/unlock?quantity={quantity}")
    Result<Inventory> unlockStock(@Param("id") Long id, @Param("quantity") Integer quantity);
    
    @RequestLine("GET /api/inventory/export")
    Result<String> exportInventory();
    
    @RequestLine("POST /api/inventory/{id}/adjust?quantity={quantity}&reason={reason}")
    Result<Inventory> adjustInventory(
            @Param("id") Long id,
            @Param("quantity") Integer quantity,
            @Param("reason") String reason);
    
    @RequestLine("GET /api/inventory/alerts")
    Result<List<InventoryAlertVO>> getAlerts();
}

class StockInReq {
    private Long productId;
    private Integer quantity;
    private BigDecimal costPrice;
    private String warehouse;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getCostPrice() { return costPrice; }
    public void setCostPrice(BigDecimal costPrice) { this.costPrice = costPrice; }
    public String getWarehouse() { return warehouse; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }
}

class StockOutReq {
    private Long productId;
    private Integer quantity;
    private String warehouse;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getWarehouse() { return warehouse; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }
}

class InventoryCheckVO {
    private Long productId;
    private Integer availableQuantity;
    private Integer requiredQuantity;
    private Boolean isAvailable;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getAvailableQuantity() { return availableQuantity; }
    public void setAvailableQuantity(Integer availableQuantity) { this.availableQuantity = availableQuantity; }
    public Integer getRequiredQuantity() { return requiredQuantity; }
    public void setRequiredQuantity(Integer requiredQuantity) { this.requiredQuantity = requiredQuantity; }
    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }
}

class InventoryHistoryVO {
    private Long id;
    private Long productId;
    private String action;
    private Integer quantity;
    private Integer beforeQuantity;
    private Integer afterQuantity;
    private String operator;
    private String createdAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getBeforeQuantity() { return beforeQuantity; }
    public void setBeforeQuantity(Integer beforeQuantity) { this.beforeQuantity = beforeQuantity; }
    public Integer getAfterQuantity() { return afterQuantity; }
    public void setAfterQuantity(Integer afterQuantity) { this.afterQuantity = afterQuantity; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}

class InventoryStatisticsVO {
    private Long totalProducts;
    private Long lowStockProducts;
    private Long outOfStockProducts;
    private Integer totalQuantity;
    private Integer totalValue;
    
    public Long getTotalProducts() { return totalProducts; }
    public void setTotalProducts(Long totalProducts) { this.totalProducts = totalProducts; }
    public Long getLowStockProducts() { return lowStockProducts; }
    public void setLowStockProducts(Long lowStockProducts) { this.lowStockProducts = lowStockProducts; }
    public Long getOutOfStockProducts() { return outOfStockProducts; }
    public void setOutOfStockProducts(Long outOfStockProducts) { this.outOfStockProducts = outOfStockProducts; }
    public Integer getTotalQuantity() { return totalQuantity; }
    public void setTotalQuantity(Integer totalQuantity) { this.totalQuantity = totalQuantity; }
    public Integer getTotalValue() { return totalValue; }
    public void setTotalValue(Integer totalValue) { this.totalValue = totalValue; }
}

class InventoryAlertVO {
    private Long productId;
    private String productName;
    private Integer currentQuantity;
    private Integer threshold;
    private String alertType;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Integer getCurrentQuantity() { return currentQuantity; }
    public void setCurrentQuantity(Integer currentQuantity) { this.currentQuantity = currentQuantity; }
    public Integer getThreshold() { return threshold; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }
    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
}
