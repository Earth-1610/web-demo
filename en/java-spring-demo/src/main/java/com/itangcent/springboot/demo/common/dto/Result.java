package com.itangcent.springboot.demo.common.dto;

/**
 * Generic Response Result Class
 * @param <T> Type parameter for response data
 */
public class Result<T> implements IResult<T> {
    /**
     * Response Status Code
     * 0 indicates success, other values indicate failure
     */
    private int code;

    /**
     * Response Message
     * "success" for successful operations, error message for failures
     */
    private String msg;

    /**
     * Response Data
     * Contains the actual returned data when successful
     */
    private T data;

    /**
     * Default Constructor
     */
    public Result() {
    }

    /**
     * Constructor with Parameters
     * @param code Status code
     * @param msg Message
     * @param data Data
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Create Success Response
     * @param data Response data
     * @return Successful response result
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