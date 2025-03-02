package com.itangcent.common.dto;

/**
 * API Response Interface
 */
public interface IResult {
    /**
     * Get response code
     * @return Response code
     */
    int getCode();

    /**
     * Get response message
     * @return Response message
     */
    String getMessage();
} 