package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Order;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.math.BigDecimal;
import java.util.List;

public interface OrderClient {
    
    @RequestLine("GET /api/orders?userId={userId}&orderNo={orderNo}&status={status}&startDate={startDate}&endDate={endDate}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Order>> listOrders(
            @Param("userId") Long userId,
            @Param("orderNo") String orderNo,
            @Param("status") Integer status,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/orders")
    Result<Order> createOrder(CreateOrderReq req);
    
    @RequestLine("GET /api/orders/{id}")
    Result<Order> getOrder(@Param("id") Long id);
    
    @RequestLine("PUT /api/orders/{id}")
    Result<Order> updateOrder(@Param("id") Long id, UpdateOrderReq req);
    
    @RequestLine("DELETE /api/orders/{id}")
    Result<Void> deleteOrder(@Param("id") Long id);
    
    @RequestLine("POST /api/orders/{id}/cancel?reason={reason}")
    Result<Order> cancelOrder(@Param("id") Long id, @Param("reason") String reason);
    
    @RequestLine("PUT /api/orders/{id}/status?status={status}")
    Result<Order> updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    @RequestLine("GET /api/orders/{id}/track")
    Result<OrderTrackVO> trackOrder(@Param("id") Long id);
    
    @RequestLine("GET /api/orders/user/{userId}?status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Order>> getUserOrders(
            @Param("userId") Long userId,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/orders/user/{userId}/history?limit={limit}")
    Result<List<Order>> getOrderHistory(@Param("userId") Long userId, @Param("limit") Integer limit);
    
    @RequestLine("POST /api/orders/calculate")
    Result<OrderCalculationVO> calculateOrder(CalculateOrderReq req);
    
    @RequestLine("POST /api/orders/{id}/apply-discount?discountCode={discountCode}")
    Result<Order> applyDiscount(@Param("id") Long id, @Param("discountCode") String discountCode);
    
    @RequestLine("DELETE /api/orders/{id}/discount")
    Result<Order> removeDiscount(@Param("id") Long id);
    
    @RequestLine("GET /api/orders/{id}/items")
    Result<List<OrderItemVO>> getOrderItems(@Param("id") Long id);
    
    @RequestLine("POST /api/orders/{id}/items")
    Result<OrderItemVO> addOrderItem(@Param("id") Long id, AddOrderItemReq req);
    
    @RequestLine("DELETE /api/orders/{id}/items/{itemId}")
    Result<Void> removeOrderItem(@Param("id") Long id, @Param("itemId") Long itemId);
    
    @RequestLine("PUT /api/orders/{id}/items/{itemId}?quantity={quantity}")
    Result<OrderItemVO> updateOrderItem(
            @Param("id") Long id,
            @Param("itemId") Long itemId,
            @Param("quantity") Integer quantity);
    
    @RequestLine("GET /api/orders/{id}/payment")
    Result<PaymentInfoVO> getPaymentInfo(@Param("id") Long id);
    
    @RequestLine("GET /api/orders/{id}/shipping")
    Result<ShippingInfoVO> getShippingInfo(@Param("id") Long id);
    
    @RequestLine("PUT /api/orders/{id}/shipping-address")
    Result<Order> updateShippingAddress(@Param("id") Long id, UpdateShippingAddressReq req);
    
    @RequestLine("POST /api/orders/{id}/confirm")
    Result<Order> confirmOrder(@Param("id") Long id);
    
    @RequestLine("POST /api/orders/{id}/complete")
    Result<Order> completeOrder(@Param("id") Long id);
    
    @RequestLine("POST /api/orders/{id}/refund")
    Result<RefundVO> requestRefund(@Param("id") Long id, RefundReq req);
    
    @RequestLine("GET /api/orders/{id}/refund")
    Result<RefundVO> getRefundInfo(@Param("id") Long id);
    
    @RequestLine("GET /api/orders/statistics?startDate={startDate}&endDate={endDate}")
    Result<OrderStatisticsVO> getStatistics(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/orders/statistics/user/{userId}")
    Result<UserOrderStatisticsVO> getUserStatistics(@Param("userId") Long userId);
    
    @RequestLine("GET /api/orders/{id}/invoice")
    Result<InvoiceVO> getInvoice(@Param("id") Long id);
    
    @RequestLine("POST /api/orders/{id}/invoice")
    Result<InvoiceVO> createInvoice(@Param("id") Long id, CreateInvoiceReq req);
    
    @RequestLine("GET /api/orders/export?startDate={startDate}&endDate={endDate}&status={status}")
    Result<String> exportOrders(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("status") Integer status);
    
    @RequestLine("POST /api/orders/batch-cancel?reason={reason}")
    Result<Void> batchCancel(List<Long> ids, @Param("reason") String reason);
    
    @RequestLine("GET /api/orders/pending-count")
    Result<Long> getPendingCount();
    
    @RequestLine("GET /api/orders/user/{userId}/pending-count")
    Result<Long> getUserPendingCount(@Param("userId") Long userId);
    
    @RequestLine("POST /api/orders/{id}/remark?remark={remark}")
    Result<Order> addRemark(@Param("id") Long id, @Param("remark") String remark);
    
    @RequestLine("GET /api/orders/{id}/logs")
    Result<List<OrderLogVO>> getOrderLogs(@Param("id") Long id);
}

class CreateOrderReq {
    private Long userId;
    private List<OrderItemReq> items;
    private String shippingAddress;
    private String receiverName;
    private String receiverPhone;
    private String paymentMethod;
    private String discountCode;
    private String remark;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<OrderItemReq> getItems() { return items; }
    public void setItems(List<OrderItemReq> items) { this.items = items; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getDiscountCode() { return discountCode; }
    public void setDiscountCode(String discountCode) { this.discountCode = discountCode; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}

class OrderItemReq {
    private Long productId;
    private Integer quantity;
    private String spec;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getSpec() { return spec; }
    public void setSpec(String spec) { this.spec = spec; }
}

class UpdateOrderReq {
    private String shippingAddress;
    private String receiverName;
    private String receiverPhone;
    private String remark;
    
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}

class OrderTrackVO {
    private String orderNo;
    private Integer status;
    private String carrier;
    private String trackingNo;
    private List<TrackPointVO> trackPoints;
    
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public String getTrackingNo() { return trackingNo; }
    public void setTrackingNo(String trackingNo) { this.trackingNo = trackingNo; }
    public List<TrackPointVO> getTrackPoints() { return trackPoints; }
    public void setTrackPoints(List<TrackPointVO> trackPoints) { this.trackPoints = trackPoints; }
}

class TrackPointVO {
    private String time;
    private String location;
    private String description;
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

class OrderCalculationVO {
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal shipping;
    private BigDecimal tax;
    private BigDecimal total;
    
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }
    public BigDecimal getShipping() { return shipping; }
    public void setShipping(BigDecimal shipping) { this.shipping = shipping; }
    public BigDecimal getTax() { return tax; }
    public void setTax(BigDecimal tax) { this.tax = tax; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}

class CalculateOrderReq {
    private List<OrderItemReq> items;
    private String discountCode;
    private String shippingAddress;
    
    public List<OrderItemReq> getItems() { return items; }
    public void setItems(List<OrderItemReq> items) { this.items = items; }
    public String getDiscountCode() { return discountCode; }
    public void setDiscountCode(String discountCode) { this.discountCode = discountCode; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}

class OrderItemVO {
    private Long id;
    private Long productId;
    private String productName;
    private String productImage;
    private BigDecimal price;
    private Integer quantity;
    private String spec;
    private BigDecimal subtotal;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductImage() { return productImage; }
    public void setProductImage(String productImage) { this.productImage = productImage; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getSpec() { return spec; }
    public void setSpec(String spec) { this.spec = spec; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}

class AddOrderItemReq {
    private Long productId;
    private Integer quantity;
    private String spec;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getSpec() { return spec; }
    public void setSpec(String spec) { this.spec = spec; }
}

class PaymentInfoVO {
    private String paymentNo;
    private BigDecimal amount;
    private String paymentMethod;
    private Integer status;
    private String paidAt;
    
    public String getPaymentNo() { return paymentNo; }
    public void setPaymentNo(String paymentNo) { this.paymentNo = paymentNo; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getPaidAt() { return paidAt; }
    public void setPaidAt(String paidAt) { this.paidAt = paidAt; }
}

class ShippingInfoVO {
    private String shippingNo;
    private String carrier;
    private String trackingNo;
    private Integer status;
    private String shippedAt;
    private String deliveredAt;
    
    public String getShippingNo() { return shippingNo; }
    public void setShippingNo(String shippingNo) { this.shippingNo = shippingNo; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public String getTrackingNo() { return trackingNo; }
    public void setTrackingNo(String trackingNo) { this.trackingNo = trackingNo; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getShippedAt() { return shippedAt; }
    public void setShippedAt(String shippedAt) { this.shippedAt = shippedAt; }
    public String getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(String deliveredAt) { this.deliveredAt = deliveredAt; }
}

class UpdateShippingAddressReq {
    private String shippingAddress;
    private String receiverName;
    private String receiverPhone;
    
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }
}

class RefundVO {
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String reason;
    private Integer status;
    private String processedAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getProcessedAt() { return processedAt; }
    public void setProcessedAt(String processedAt) { this.processedAt = processedAt; }
}

class RefundReq {
    private BigDecimal amount;
    private String reason;
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

class OrderStatisticsVO {
    private Long totalOrders;
    private Long pendingOrders;
    private Long completedOrders;
    private Long cancelledOrders;
    private BigDecimal totalRevenue;
    private BigDecimal averageOrderValue;
    
    public Long getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Long totalOrders) { this.totalOrders = totalOrders; }
    public Long getPendingOrders() { return pendingOrders; }
    public void setPendingOrders(Long pendingOrders) { this.pendingOrders = pendingOrders; }
    public Long getCompletedOrders() { return completedOrders; }
    public void setCompletedOrders(Long completedOrders) { this.completedOrders = completedOrders; }
    public Long getCancelledOrders() { return cancelledOrders; }
    public void setCancelledOrders(Long cancelledOrders) { this.cancelledOrders = cancelledOrders; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
    public BigDecimal getAverageOrderValue() { return averageOrderValue; }
    public void setAverageOrderValue(BigDecimal averageOrderValue) { this.averageOrderValue = averageOrderValue; }
}

class UserOrderStatisticsVO {
    private Long totalOrders;
    private Long pendingOrders;
    private Long completedOrders;
    private BigDecimal totalSpent;
    
    public Long getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Long totalOrders) { this.totalOrders = totalOrders; }
    public Long getPendingOrders() { return pendingOrders; }
    public void setPendingOrders(Long pendingOrders) { this.pendingOrders = pendingOrders; }
    public Long getCompletedOrders() { return completedOrders; }
    public void setCompletedOrders(Long completedOrders) { this.completedOrders = completedOrders; }
    public BigDecimal getTotalSpent() { return totalSpent; }
    public void setTotalSpent(BigDecimal totalSpent) { this.totalSpent = totalSpent; }
}

class InvoiceVO {
    private Long id;
    private String invoiceNo;
    private String title;
    private String content;
    private BigDecimal amount;
    private String issuedAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInvoiceNo() { return invoiceNo; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getIssuedAt() { return issuedAt; }
    public void setIssuedAt(String issuedAt) { this.issuedAt = issuedAt; }
}

class CreateInvoiceReq {
    private String title;
    private String content;
    private String email;
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class OrderLogVO {
    private Long id;
    private String action;
    private String description;
    private String operator;
    private String createdAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
