package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserContent;
import com.itangcent.springboot.demo.common.annotation.UserContext;
import org.springframework.web.bind.annotation.*;

/**
 * 自定义注解参数处理控制器
 * 演示如何处理自定义注解和系统自动填充的参数
 * 展示API文档中参数的忽略规则
 */
@RestController
@RequestMapping("/testParamsWithCustomAnno")
public class WithCustomAnnController {

    /**
     * 自定义注解参数测试
     * 演示使用@UserContext注解自动注入用户上下文
     *
     * @param paramShouldNotIgnore 普通请求参数，会在API文档中显示
     * @param userContent 用户上下文对象（由系统自动注入，在API文档中被忽略）
     * @return 返回处理结果
     */
    @PostMapping("/custom/ann")
    public IResult testParamsWithCustomAnno(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @UserContext UserContent userContent) {
        return Result.success("ok");
    }

    /**
     * 自动填充Token测试
     * 演示系统自动处理请求头中的token
     *
     * @param paramShouldNotIgnore 普通请求参数，会在API文档中显示
     * @param token 认证令牌（由系统自动获取，在API文档中被忽略）
     * @return 返回处理结果
     */
    @PostMapping("/auto/fill/token")
    public IResult testAutoFillToken(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @RequestHeader("token") String token) {
        return Result.success("ok");
    }
}
