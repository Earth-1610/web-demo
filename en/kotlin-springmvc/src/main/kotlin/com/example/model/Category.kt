package com.example.model

data class Category(
    val id: Long? = null,
    val name: String? = null,
    val parentId: Long? = null,
    val level: Int? = null,
    val sortOrder: Int? = null,
    val icon: String? = null,
    val status: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
