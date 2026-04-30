package com.example.model

import java.math.BigDecimal

data class Product(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val price: BigDecimal? = null,
    val originalPrice: BigDecimal? = null,
    val categoryId: Long? = null,
    val stock: Int? = null,
    val sales: Int? = null,
    val mainImage: String? = null,
    val images: String? = null,
    val unit: String? = null,
    val status: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
