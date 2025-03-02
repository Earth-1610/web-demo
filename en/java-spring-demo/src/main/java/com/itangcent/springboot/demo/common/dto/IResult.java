package com.itangcent.springboot.demo.common.dto;

/**
 * Generic Response Result Interface
 * Defines the standard structure for API responses
 * @param <T> Type parameter for response data
 */
public interface IResult<T> {
    /**
     * Get Response Status Code
     * @return Status code, 0 indicates success, other values indicate failure
     */
    int getCode();

    /**
     * Get Response Message
     * @return Response description message
     */
    String getMsg();

    /**
     * Get Response Data
     * @return Actual response data object
     */
    T getData();
} 