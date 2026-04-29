package com.example.model

data class Shipping(
    val id: Long? = null,
    val shippingNo: String? = null,
    val orderId: Long? = null,
    val carrier: String? = null,
    val trackingNo: String? = null,
    val status: Int? = null,
    val shippedAt: String? = null,
    val deliveredAt: String? = null,
    val receiverName: String? = null,
    val receiverPhone: String? = null,
    val address: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
