package com.itangcent.common.dto;

/**
 * API响应结果封装类
 * 统一封装API接口的响应数据，包含状态码、消息和数据
 *
 * @param <T> 响应数据的类型参数
 */
public class Result<T> implements IResult {
    /**
     * 响应状态码
     * 200表示成功，其他值表示失败
     */
    private int code;

    /**
     * 响应消息
     * 成功时为"success"，失败时包含错误信息
     */
    private String message;

    /**
     * 响应数据
     * 成功时包含实际返回的数据，失败时可能为null
     */
    private T data;

    /**
     * 默认构造函数
     */
    public Result() {
    }

    /**
     * 构造包含状态码和消息的响应结果
     *
     * @param code 响应状态码
     * @param message 响应消息
     */
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造完整的响应结果
     *
     * @param code 响应状态码
     * @param message 响应消息
     * @param data 响应数据
     */
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 创建成功响应
     * 使用默认成功状态码(200)和消息
     *
     * @param data 响应数据
     * @return 成功的响应结果
     * @param <T> 响应数据类型
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    /**
     * 创建错误响应
     * 用于返回自定义错误信息
     *
     * @param code 错误状态码
     * @param message 错误消息
     * @return 错误的响应结果
     * @param <T> 响应数据类型
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
} 