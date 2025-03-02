package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * 用户管理控制器
 * 提供用户信息的增删改查等基本操作
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl {

    /**
     * 欢迎接口
     * 返回简单的问候信息
     *
     * @return 问候信息
     */
    @RequestMapping(value = "/index")
    public Mono<String> greeting() {
        return Mono.just("hello world");
    }

    /**
     * 更新用户名称
     * 根据用户ID更新用户的名称和其他信息
     *
     * @param id 用户ID
     * @param newName 新的用户名
     * @param slogon 个性签名
     * @param times 操作次数
     * @return 更新后的用户信息
     * @deprecated 请使用 {@link #update(UserInfo)} 替代
     */
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Mono<Object> set(long id,
                            @RequestParam String newName,
                            @RequestParam(required = false, defaultValue = "haha") String slogon,
                            @RequestParam(required = false, defaultValue = "10") long times) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 获取用户信息
     * 根据用户ID查询用户的详细信息
     *
     * @param id 用户ID
     * @return 用户信息
     * @deprecated 此接口已废弃，请使用新版本的查询接口
     */
    @Deprecated
    @GetMapping("/get/{id}")
    public Mono<IResult> get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 创建新用户
     * 添加一个新的用户信息到系统
     *
     * @param userInfo 用户信息对象
     * @return 创建结果，包含新用户信息
     */
    @PostMapping("/add")
    public Mono<Result<UserInfo>> add(@RequestBody UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 更新用户信息
     * 更新指定用户的所有信息
     *
     * @param userInfo 更新后的用户信息
     * @return 更新结果
     */
    @PutMapping("/update")
    public Mono<IResult> update(@ModelAttribute UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 获取用户列表
     * 查询系统中所有用户的信息
     *
     * @return 用户列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Mono<IResult> list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Mono.just(Result.success(Collections.singletonList(userInfo)));
    }

    /**
     * 删除用户
     * 根据用户ID删除指定用户的信息
     *
     * @param id 要删除的用户ID
     * @return 删除结果，包含被删除的用户信息
     */
    @DeleteMapping("/{id}")
    public Mono<IResult> delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

}
