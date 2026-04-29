package com.example.dto;

import java.math.BigDecimal;

public class OrderRefundReq {
    private BigDecimal amount;
    private String reason;
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
