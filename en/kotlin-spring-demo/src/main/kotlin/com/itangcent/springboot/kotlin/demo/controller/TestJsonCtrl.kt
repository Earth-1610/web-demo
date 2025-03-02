package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.model.TestJsonFieldBean
import com.itangcent.common.model.TestJsonIgnoreBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * JSON Test Controller
 * Used to test JSON field serialization and deserialization functionality
 */
@RestController
@RequestMapping("/test/json")
class TestJsonCtrl {

    /**
     * Test JSON Field Name Mapping
     * Demonstrates how to use custom field names for JSON serialization
     *
     * @param testJsonFieldBean Test object with custom field names
     * @return Returns the original test object
     */
    @RequestMapping("/field")
    fun field(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

    /**
     * Test JSON Field Ignore
     * Demonstrates how to ignore specific fields during JSON serialization
     *
     * @param testJsonIgnoreBean Test object with fields to be ignored
     * @return Returns the original test object
     */
    @RequestMapping("/ignore")
    fun ignore(
            @RequestBody testJsonIgnoreBean: TestJsonIgnoreBean): TestJsonIgnoreBean {
        return testJsonIgnoreBean
    }
}
