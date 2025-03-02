package com.itangcent.common.dto

/**
 * 通用响应结果接口
 * 定义了API响应的标准数据结构
 * @param T 响应数据的类型参数
 */
interface IResult<T> {
    /**
     * 获取响应状态码
     * @return 状态码，0表示成功，其他值表示失败
     */
    val code: Int

    /**
     * 获取响应消息
     * @return 响应的描述信息，成功时通常为"success"，失败时为错误描述
     */
    val msg: String

    /**
     * 获取响应数据
     * @return 实际的响应数据对象，类型为泛型T
     */
    val data: T
} 