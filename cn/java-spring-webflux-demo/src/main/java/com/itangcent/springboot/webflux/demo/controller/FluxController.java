package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.Result;
import com.itangcent.springboot.webflux.demo.reactive.function.Person;
import com.itangcent.springboot.webflux.demo.reactive.function.PersonHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * WebFlux响应式控制器
 * 演示响应式编程的基本用法
 */
@RestController
@RequestMapping("restful")
public class FluxController {

    /**
     * 人员信息处理器
     */
    private final PersonHandler personHandler;

    /**
     * 构造函数
     * 
     * @param personHandler 人员信息处理器
     */
    public FluxController(PersonHandler personHandler) {
        this.personHandler = personHandler;
    }

    /**
     * 返回空响应示例
     * 演示Mono的基本用法
     * 
     * @return 空的响应结果
     */
    @GetMapping("/")
    public Mono<Result<String>> empty() {
        return Mono.just(Result.success(null));
    }

    /**
     * 返回单个字符串示例
     * 演示Mono包装单个值的用法
     * 
     * @return 包含字符串的响应结果
     */
    @GetMapping("/single")
    public Mono<Result<String>> single() {
        return Mono.just(Result.success("single"));
    }

    /**
     * 创建人员信息
     * 演示响应式处理POST请求
     * 
     * @param person 人员信息
     * @return 创建结果
     */
    @PostMapping("/person")
    public Mono<Result<Void>> create(@RequestBody Person person) {
        return this.personHandler.createPerson(person)
                .then(Mono.just(Result.success(null)));
    }

    /**
     * 获取所有人员列表
     * 演示Flux的基本用法
     * 
     * @return 人员列表流
     */
    @GetMapping("/person")
    public Flux<Person> list() {
        return this.personHandler.listPeople();
    }

    /**
     * 根据ID获取人员信息
     * 演示带路径参数的响应式处理
     * 
     * @param id 人员ID
     * @return 人员信息
     */
    @GetMapping("/person/{id}")
    public Mono<Result<Person>> findById(@PathVariable int id) {
        return this.personHandler.getPerson(id)
                .map(Result::success)
                .defaultIfEmpty(Result.error(404, "未找到指定人员"));
    }

    /**
     * 测试错误响应
     * 演示响应式错误处理
     * 
     * @return 错误响应
     */
    @GetMapping("/error")
    public Mono<Result<Person>> error() {
        return Mono.error(new RuntimeException("测试错误响应"));
    }
}
