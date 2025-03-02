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
 * 测试控制器
 * 用于演示各种请求参数和响应处理的基本用法
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {

    /**
     * 测试请求头参数
     * 演示如何获取和处理HTTP请求头中的参数
     *
     * @param token 认证令牌
     * @return 接收到的令牌值
     */
    @RequestMapping("/header")
    public Mono<String> header(
            @RequestHeader("token") String token) {
        return Mono.just(token);
    }

    /**
     * 测试数组参数处理
     * 演示如何处理多个同名参数或数组类型参数
     *
     * @param strings 字符串数组参数
     * @param ints 整数数组参数
     * @return 处理结果
     */
    @RequestMapping("/arrays")
    public Mono<String> header(@RequestParam(name = "string") String[] strings,
                               @RequestParam(name = "int") int[] ints) {
        return Mono.just("ok" + strings);
    }

    /**
     * 测试被忽略的方法
     * 此方法不会包含在API文档中
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    public Mono<String> ignore() {
        return Mono.just("ignore");
    }

    /**
     * 测试Servlet请求对象
     * 演示如何在WebFlux中处理传统的Servlet请求
     */
    @RequestMapping("/httpServletRequest")
    public Mono<String> request() {
        return Mono.just("javax.servlet.http.HttpServletRequest");
    }

    /**
     * 测试Servlet响应对象
     * 演示如何在WebFlux中处理传统的Servlet响应
     */
    @RequestMapping("/httpServletResponse")
    public Mono<String> response() {
        return Mono.just("javax.servlet.http.HttpServletResponse");
    }

    /**
     * 推断包含集合的响应
     * 演示如何处理复杂的集合类型响应
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
