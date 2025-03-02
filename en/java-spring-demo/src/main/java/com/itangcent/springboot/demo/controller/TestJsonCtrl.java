package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.model.TestJsonFieldBean;
import com.itangcent.springboot.demo.common.model.TestJsonIgnoreBean;
import com.itangcent.springboot.demo.common.model.TestLogBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * JSON Serialization Test Controller
 * Demonstrates various features of Jackson annotations
 * Including field naming, field ignoring, transient keyword, and other features
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * JSON field naming test
     * Demonstrates custom field naming using @JsonProperty annotation
     *
     * @param testJsonFieldBean Test object with custom field names
     * @return Returns the request object as is
     * @public Marked as public interface
     */
    @RequestMapping("/field")
    public TestJsonFieldBean field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * JSON field ignore test
     * Demonstrates field ignoring using @JsonIgnore annotation
     *
     * @param testJsonIgnoreBean Test object with ignored fields
     * @return Returns the request object as is (ignored fields won't be serialized)
     */
    @RequestMapping("/ignore")
    public TestJsonIgnoreBean ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return testJsonIgnoreBean;
    }

    /**
     * Transient keyword test
     * Demonstrates fields marked with transient are ignored during serialization
     *
     * @param testLogBean Test object with transient fields
     * @return Returns the request object as is (transient fields won't be serialized)
     */
    @RequestMapping("/ignore/transient")
    public TestLogBean ignoreTransient(
            @RequestBody TestLogBean testLogBean) {
        return testLogBean;
    }
}
