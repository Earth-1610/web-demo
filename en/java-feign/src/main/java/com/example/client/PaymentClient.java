package com.example.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import com.example.dto.*;
import com.example.model.Payment;
import java.math.BigDecimal;
import java.util.List;

public interface PaymentClient {
    
    @RequestLine("GET /api/payments?orderId={orderId}&paymentNo={paymentNo}&status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Payment>> listPayments(
            @Param("orderId") Long orderId,
            @Param("paymentNo") String paymentNo,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/payments")
    Result<Payment> createPayment(CreatePaymentReq req);
    
    @RequestLine("GET /api/payments/{id}")
    Result<Payment> getPayment(@Param("id") Long id);
    
    @RequestLine("GET /api/payments/no/{paymentNo}")
    Result<Payment> getPaymentByNo(@Param("paymentNo") String paymentNo);
    
    @RequestLine("POST /api/payments/{id}/cancel")
    Result<Payment> cancelPayment(@Param("id") Long id);
    
    @RequestLine("POST /api/payments/{id}/refund")
    Result<RefundVO> processRefund(@Param("id") Long id, RefundReq req);
    
    @RequestLine("GET /api/payments/order/{orderId}")
    Result<List<Payment>> getPaymentsByOrder(@Param("orderId") Long orderId);
    
    @RequestLine("GET /api/payments/history?startDate={startDate}&endDate={endDate}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Payment>> getPaymentHistory(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/payments/{id}/verify?transactionId={transactionId}")
    Result<PaymentVerifyVO> verifyPayment(@Param("id") Long id, @Param("transactionId") String transactionId);
    
    @RequestLine("GET /api/payments/methods")
    Result<List<PaymentMethodVO>> getPaymentMethods();
    
    @RequestLine("GET /api/payments/statistics?startDate={startDate}&endDate={endDate}")
    Result<PaymentStatisticsVO> getStatistics(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/payments/pending?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Payment>> getPendingPayments(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/payments/failed?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Payment>> getFailedPayments(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/payments/{id}/retry")
    Result<Payment> retryPayment(@Param("id") Long id);
    
    @RequestLine("GET /api/payments/{id}/status")
    Result<PaymentStatusVO> getPaymentStatus(@Param("id") Long id);
    
    @RequestLine("POST /api/payments/callback")
    Result<Void> paymentCallback(String callbackData);
    
    @RequestLine("GET /api/payments/export?startDate={startDate}&endDate={endDate}")
    Result<String> exportPayments(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/payments/{id}/receipt")
    Result<PaymentReceiptVO> getReceipt(@Param("id") Long id);
    
    @RequestLine("POST /api/payments/{id}/send-receipt?email={email}")
    Result<Void> sendReceipt(@Param("id") Long id, @Param("email") String email);
}

class CreatePaymentReq {
    private Long orderId;
    private BigDecimal amount;
    private String paymentMethod;
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}

class PaymentVerifyVO {
    private Long paymentId;
    private Boolean verified;
    private String transactionId;
    private String verifiedAt;
    
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
    public Boolean getVerified() { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(String verifiedAt) { this.verifiedAt = verifiedAt; }
}

class PaymentMethodVO {
    private String code;
    private String name;
    private String icon;
    private Boolean enabled;
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
}

class PaymentStatisticsVO {
    private Long totalPayments;
    private Long successfulPayments;
    private Long failedPayments;
    private BigDecimal totalAmount;
    private BigDecimal refundedAmount;
    
    public Long getTotalPayments() { return totalPayments; }
    public void setTotalPayments(Long totalPayments) { this.totalPayments = totalPayments; }
    public Long getSuccessfulPayments() { return successfulPayments; }
    public void setSuccessfulPayments(Long successfulPayments) { this.successfulPayments = successfulPayments; }
    public Long getFailedPayments() { return failedPayments; }
    public void setFailedPayments(Long failedPayments) { this.failedPayments = failedPayments; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public BigDecimal getRefundedAmount() { return refundedAmount; }
    public void setRefundedAmount(BigDecimal refundedAmount) { this.refundedAmount = refundedAmount; }
}

class PaymentStatusVO {
    private Long paymentId;
    private String paymentNo;
    private Integer status;
    private String statusDescription;
    private String updatedAt;
    
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
    public String getPaymentNo() { return paymentNo; }
    public void setPaymentNo(String paymentNo) { this.paymentNo = paymentNo; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getStatusDescription() { return statusDescription; }
    public void setStatusDescription(String statusDescription) { this.statusDescription = statusDescription; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}

class PaymentReceiptVO {
    private String receiptNo;
    private String paymentNo;
    private BigDecimal amount;
    private String paymentMethod;
    private String paidAt;
    private String receiptUrl;
    
    public String getReceiptNo() { return receiptNo; }
    public void setReceiptNo(String receiptNo) { this.receiptNo = receiptNo; }
    public String getPaymentNo() { return paymentNo; }
    public void setPaymentNo(String paymentNo) { this.paymentNo = paymentNo; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getPaidAt() { return paidAt; }
    public void setPaidAt(String paidAt) { this.paidAt = paidAt; }
    public String getReceiptUrl() { return receiptUrl; }
    public void setReceiptUrl(String receiptUrl) { this.receiptUrl = receiptUrl; }
}
