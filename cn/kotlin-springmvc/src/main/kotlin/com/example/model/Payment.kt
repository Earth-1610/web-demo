package com.example.model

import java.math.BigDecimal

data class Payment(
    val id: Long? = null,
    val paymentNo: String? = null,
    val orderId: Long? = null,
    val amount: BigDecimal? = null,
    val paymentMethod: String? = null,
    val status: Int? = null,
    val transactionId: String? = null,
    val paidAt: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
