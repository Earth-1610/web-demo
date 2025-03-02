package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.model.TestJsonFieldBean
import com.itangcent.common.model.TestJsonIgnoreBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * JSON测试控制器
 * 用于测试JSON字段序列化和反序列化的相关功能
 */
@RestController
@RequestMapping("/test/json")
class TestJsonCtrl {

    /**
     * 测试JSON字段名映射
     * 演示如何使用自定义字段名进行JSON序列化
     *
     * @param testJsonFieldBean 包含自定义字段名的测试对象
     * @return 返回原测试对象
     */
    @RequestMapping("/field")
    fun field(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

    /**
     * 测试JSON字段忽略
     * 演示如何在JSON序列化时忽略特定字段
     *
     * @param testJsonIgnoreBean 包含需要忽略字段的测试对象
     * @return 返回原测试对象
     */
    @RequestMapping("/ignore")
    fun ignore(
            @RequestBody testJsonIgnoreBean: TestJsonIgnoreBean): TestJsonIgnoreBean {
        return testJsonIgnoreBean
    }
}
