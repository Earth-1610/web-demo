package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;


/**
 * 安全控制器
 * 用于演示基于角色的访问控制功能
 */
@RestController
@RequestMapping(value = "/test/security")
public class SecurityCtrl {

    /**
     * 测试角色权限控制
     * 演示使用@RolesAllowed注解进行访问控制
     * 只有具有admin角色的用户才能访问此接口
     *
     * @param testJsonFieldBean 测试数据对象
     * @return 处理结果
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    public Mono<TestJsonFieldBean> rolesAllowed(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return Mono.just(testJsonFieldBean);
    }

}
