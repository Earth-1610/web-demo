package com.itangcent.common.dto;

/**
 * API Response Result Wrapper Class
 * Unified wrapper for API interface response data, including status code, message, and data
 *
 * @param <T> Type parameter for response data
 */
public class Result<T> implements IResult {
    /**
     * Response status code
     * 200 indicates success, other values indicate failure
     */
    private int code;

    /**
     * Response message
     * "success" for successful operations, contains error information for failures
     */
    private String message;

    /**
     * Response data
     * Contains actual returned data on success, may be null on failure
     */
    private T data;

    /**
     * Default constructor
     */
    public Result() {
    }

    /**
     * Construct response result with status code and message
     *
     * @param code Response status code
     * @param message Response message
     */
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Construct complete response result
     *
     * @param code Response status code
     * @param message Response message
     * @param data Response data
     */
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Create success response
     * Uses default success status code (200) and message
     *
     * @param data Response data
     * @return Successful response result
     * @param <T> Response data type
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    /**
     * Create error response
     * Used to return custom error information
     *
     * @param code Error status code
     * @param message Error message
     * @return Error response result
     * @param <T> Response data type
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