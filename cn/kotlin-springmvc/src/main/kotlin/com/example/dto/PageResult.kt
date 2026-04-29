package com.example.dto

data class PageResult<T>(
    val list: List<T>? = null,
    val total: Long = 0,
    val pageNum: Int = 1,
    val pageSize: Int = 10,
    val pages: Int = 0
)
