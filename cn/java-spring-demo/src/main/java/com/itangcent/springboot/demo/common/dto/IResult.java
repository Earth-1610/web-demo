package com.itangcent.springboot.demo.common.dto;

/**
 * 通用响应结果接口
 * 定义了API响应的标准结构
 * @param <T> 响应数据的类型参数
 */
public interface IResult<T> {
    /**
     * 获取响应状态码
     * @return 状态码，0表示成功，其他值表示失败
     */
    int getCode();

    /**
     * 获取响应消息
     * @return 响应的描述信息
     */
    String getMsg();

    /**
     * 获取响应数据
     * @return 实际的响应数据对象
     */
    T getData();
} 