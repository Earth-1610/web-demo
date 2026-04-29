package com.example.model

data class Notification(
    val id: Long? = null,
    val userId: Long? = null,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val link: String? = null,
    val isRead: Int? = null,
    val createdAt: String? = null
)
