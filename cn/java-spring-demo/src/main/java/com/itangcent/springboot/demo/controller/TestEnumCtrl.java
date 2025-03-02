package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.constant.UserType;
import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.dto.UserDtoWithEnum;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * 枚举类型测试控制器
 * 演示Spring MVC中枚举类型的使用方式
 * 包括请求体、请求参数、路径变量中的枚举处理
 */
@RestController
@RequestMapping(value = "/test/enum")
public class TestEnumCtrl {

    /**
     * 枚举字段请求体测试
     * 演示请求体中包含枚举类型字段的处理
     *
     * @param userDtoWithEnum 包含枚举字段的用户DTO
     * @return 返回处理后的用户DTO（类型被设置为ADMIN）
     * @public 标记为公开接口
     */
    @RequestMapping("/echo")
    public UserDtoWithEnum echo(
            @RequestBody UserDtoWithEnum userDtoWithEnum) {
        userDtoWithEnum.setType(UserType.ADMIN);
        return userDtoWithEnum;
    }


    /**
     * 枚举请求参数测试
     * 演示@RequestParam注解处理枚举类型
     *
     * @param type 用户类型枚举值
     * @return 返回指定类型的用户列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list(@RequestParam UserType type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 枚举路径变量测试
     * 演示@PathVariable注解处理枚举类型
     *
     * @param type 用户类型枚举值（从URL路径中获取）
     * @return 返回指定类型的用户列表
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public IResult listByPath(@PathVariable("type") UserType type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }
}
