package com.example.model

import java.math.BigDecimal

data class Order(
    val id: Long? = null,
    val orderNo: String? = null,
    val userId: Long? = null,
    val totalAmount: BigDecimal? = null,
    val discountAmount: BigDecimal? = null,
    val shippingAmount: BigDecimal? = null,
    val paymentAmount: BigDecimal? = null,
    val status: Int? = null,
    val paymentMethod: String? = null,
    val paymentStatus: Int? = null,
    val shippingAddress: String? = null,
    val receiverName: String? = null,
    val receiverPhone: String? = null,
    val remark: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
