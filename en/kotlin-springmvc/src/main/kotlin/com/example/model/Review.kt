package com.example.model

data class Review(
    val id: Long? = null,
    val productId: Long? = null,
    val userId: Long? = null,
    val orderId: Long? = null,
    val rating: Int? = null,
    val title: String? = null,
    val content: String? = null,
    val images: String? = null,
    val helpfulCount: Int? = null,
    val status: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
