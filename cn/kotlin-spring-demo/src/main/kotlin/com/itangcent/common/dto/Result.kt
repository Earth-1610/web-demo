package com.itangcent.common.dto

/**
 * 通用响应结果实现类
 * 用于封装API响应的标准数据结构
 * @param T 响应数据的类型参数
 */
data class Result<T>(
    override var code: Int = 0,
    override var msg: String = "",
    override var data: T
) : IResult<T> {
    companion object {
        /**
         * 创建成功响应
         * @param data 响应数据
         * @return 返回成功的响应结果，状态码为0，消息为"success"
         */
        fun <T> success(data: T): Result<T> {
            return Result(0, "success", data)
        }
    }
} 