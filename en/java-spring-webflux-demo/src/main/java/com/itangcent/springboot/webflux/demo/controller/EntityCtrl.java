package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;


/**
 * Entity Related Operations
 */
@RestController
@RequestMapping(value = "/test/entity")
@Slf4j
public class EntityCtrl {

    /**
     * Test ResponseEntity Simple Object
     *
     * @public
     */
    @RequestMapping("/int")
    public Mono<Integer> intInEntity(
            @RequestHeader("token") String token) {
        log.info("Received token: {}", token);
        return Mono.just(65536);
    }

    /**
     * Test ResponseEntity Composite Object
     *
     * @public
     */
    @RequestMapping("/double")
    public Mono<IResult> doubleInEntity(
            @RequestHeader("token") String token) {
        log.info("Received token: {}", token);
        return Mono.just(Result.success(65536.0));
    }


}
