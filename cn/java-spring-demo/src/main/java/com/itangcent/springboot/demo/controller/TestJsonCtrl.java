package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.model.TestJsonFieldBean;
import com.itangcent.springboot.demo.common.model.TestJsonIgnoreBean;
import com.itangcent.springboot.demo.common.model.TestLogBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * JSON序列化测试控制器
 * 演示Jackson注解的各种功能
 * 包括字段命名、字段忽略、transient关键字等特性
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * JSON字段命名测试
     * 演示@JsonProperty注解自定义字段名
     *
     * @param testJsonFieldBean 包含自定义字段名的测试对象
     * @return 原样返回请求对象
     * @public 标记为公开接口
     */
    @RequestMapping("/field")
    public TestJsonFieldBean field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * JSON字段忽略测试
     * 演示@JsonIgnore注解忽略字段
     *
     * @param testJsonIgnoreBean 包含被忽略字段的测试对象
     * @return 原样返回请求对象（忽略的字段不会被序列化）
     */
    @RequestMapping("/ignore")
    public TestJsonIgnoreBean ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return testJsonIgnoreBean;
    }

    /**
     * Transient关键字测试
     * 演示transient修饰的字段在序列化时被忽略
     *
     * @param testLogBean 包含transient字段的测试对象
     * @return 原样返回请求对象（transient字段不会被序列化）
     */
    @RequestMapping("/ignore/transient")
    public TestLogBean ignoreTransient(
            @RequestBody TestLogBean testLogBean) {
        return testLogBean;
    }
}
