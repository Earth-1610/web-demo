package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import com.itangcent.common.model.TestJsonIgnoreBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * JSON Processing Controller
 * Used to demonstrate JSON data serialization and deserialization handling
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * Test JSON Field Name Mapping
     * Demonstrates using @JsonProperty annotation to customize JSON field names
     *
     * @param testJsonFieldBean Test object containing custom field names
     * @return Processed object
     */
    @RequestMapping("/field")
    public Mono<TestJsonFieldBean> field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return Mono.just(testJsonFieldBean);
    }

    /**
     * Test JSON Field Ignoring
     * Demonstrates using @JsonIgnore and @JsonIgnoreProperties annotations to ignore specific fields
     *
     * @param testJsonIgnoreBean Test object containing fields to be ignored
     * @return Processed object (with specified fields ignored)
     */
    @RequestMapping("/ignore")
    public Mono<TestJsonIgnoreBean> ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return Mono.just(testJsonIgnoreBean);
    }
}
