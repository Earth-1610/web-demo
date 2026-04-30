package com.example.model

import java.math.BigDecimal

data class Inventory(
    val id: Long? = null,
    val productId: Long? = null,
    val quantity: Int? = null,
    val lockedQuantity: Int? = null,
    val warehouse: String? = null,
    val costPrice: BigDecimal? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
