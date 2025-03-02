package com.itangcent.springboot.demo.common.dto;

/**
 * 通用响应结果类
 * @param <T> 响应数据的类型参数
 */
public class Result<T> implements IResult<T> {
    /**
     * 响应状态码
     * 0 表示成功，其他值表示失败
     */
    private int code;

    /**
     * 响应消息
     * 成功时为"success"，失败时为错误信息
     */
    private String msg;

    /**
     * 响应数据
     * 成功时包含实际返回的数据
     */
    private T data;

    /**
     * 无参构造函数
     */
    public Result() {
    }

    /**
     * 带参数的构造函数
     * @param code 状态码
     * @param msg 消息
     * @param data 数据
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 创建成功响应
     * @param data 响应数据
     * @return 成功的响应结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "success", data);
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
} 