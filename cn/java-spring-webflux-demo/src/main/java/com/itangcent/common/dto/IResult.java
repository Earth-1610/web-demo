package com.itangcent.common.dto;

/**
 * API响应接口
 */
public interface IResult {
    /**
     * 获取响应码
     * @return 响应码
     */
    int getCode();

    /**
     * 获取响应消息
     * @return 响应消息
     */
    String getMessage();
} 