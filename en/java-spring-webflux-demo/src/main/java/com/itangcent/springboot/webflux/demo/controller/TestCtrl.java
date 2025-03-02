package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Test Controller
 * Used to demonstrate basic usage of various request parameters and response handling
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {

    /**
     * Test Request Header Parameters
     * Demonstrates how to get and process parameters from HTTP request headers
     *
     * @param token Authentication token
     * @return Received token value
     */
    @RequestMapping("/header")
    public Mono<String> header(
            @RequestHeader("token") String token) {
        return Mono.just(token);
    }

    /**
     * Test Array Parameter Handling
     * Demonstrates how to handle multiple parameters with the same name or array type parameters
     *
     * @param strings String array parameter
     * @param ints Integer array parameter
     * @return Processing result
     */
    @RequestMapping("/arrays")
    public Mono<String> header(@RequestParam(name = "string") String[] strings,
                               @RequestParam(name = "int") int[] ints) {
        return Mono.just("ok" + strings);
    }

    /**
     * Test Ignored Method
     * This method will not be included in the API documentation
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    public Mono<String> ignore() {
        return Mono.just("ignore");
    }

    /**
     * Test Servlet Request Object
     * Demonstrates how to handle traditional Servlet requests in WebFlux
     */
    @RequestMapping("/httpServletRequest")
    public Mono<String> request() {
        return Mono.just("javax.servlet.http.HttpServletRequest");
    }

    /**
     * Test Servlet Response Object
     * Demonstrates how to handle traditional Servlet responses in WebFlux
     */
    @RequestMapping("/httpServletResponse")
    public Mono<String> response() {
        return Mono.just("javax.servlet.http.HttpServletResponse");
    }

    /**
     * Push Inferred Collection Response
     * Demonstrates how to handle complex collection type responses
     */
    @GetMapping("/collections")
    public Mono<IResult> collections() {
        List<Map<String, String>> data = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        data.add(map);
        return Mono.just(Result.success(data));
    }
}
