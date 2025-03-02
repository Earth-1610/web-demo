package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import com.itangcent.common.model.TestJsonIgnoreBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * JSON处理控制器
 * 用于演示JSON数据的序列化和反序列化处理
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * 测试JSON字段名映射
     * 演示使用@JsonProperty注解自定义JSON字段名
     *
     * @param testJsonFieldBean 包含自定义字段名的测试对象
     * @return 处理后的对象
     */
    @RequestMapping("/field")
    public Mono<TestJsonFieldBean> field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return Mono.just(testJsonFieldBean);
    }

    /**
     * 测试JSON字段忽略
     * 演示使用@JsonIgnore和@JsonIgnoreProperties注解忽略特定字段
     *
     * @param testJsonIgnoreBean 包含需要忽略字段的测试对象
     * @return 处理后的对象（已忽略指定字段）
     */
    @RequestMapping("/ignore")
    public Mono<TestJsonIgnoreBean> ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return Mono.just(testJsonIgnoreBean);
    }
}
