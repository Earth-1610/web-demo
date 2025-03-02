package com.itangcent.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Base Controller Class
 * Provides common functionality for all controllers
 */
public class BaseController {

    /**
     * Get the current controller's class name
     * Used for debugging and monitoring purposes
     * 
     * @return Returns the fully qualified class name of the current controller
     * @public Indicates this API is a public interface
     */
    @RequestMapping("/ctrl/name")
    public String ctrlName() {
        return getClass().getName();
    }
}
