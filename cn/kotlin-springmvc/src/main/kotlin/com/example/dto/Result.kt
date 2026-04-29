package com.example.dto

data class Result<T>(
    val code: Int = 200,
    val message: String = "success",
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(data = data)
        }
        
        fun <T> error(code: Int, message: String): Result<T> {
            return Result(code = code, message = message)
        }
    }
}
