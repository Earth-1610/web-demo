package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.annotation.Public;
import com.itangcent.springboot.demo.common.constant.UserType;
import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户管理控制器
 * 提供用户信息的增删改查等相关操作
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl extends BaseController {

    /**
     * 欢迎接口
     * 返回简单的问候语
     */
    @Public
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * 更新用户基本信息
     *
     * @param id      当前用户id - 从Cookie中获取
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @param times   操作次数，默认值为10
     * @deprecated 建议使用新接口 {@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Object set(@CookieValue(value = "currentId", required = false, defaultValue = "123") long id,
                      String newName,
                      @RequestParam String slogon,
                      @RequestParam(required = false, defaultValue = "10") long times) {

        UserInfo userInfo = new UserInfo();

        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 获取用户详细信息（旧版本）
     *
     * @param id 用户id - 通过路径参数传入
     * @undone 待完善的接口
     * @see {@link #getById(Long)} 推荐使用新版本接口
     */
    @Deprecated
    @GetMapping("/get/{id}")
    public IResult get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 根据用户ID获取用户信息（新版本）
     *
     * @param id 用户id - 通过请求参数传入
     * @undone 待完善的接口
     */
    @GetMapping(value = "/get", params = "id")
    public IResult getById(@RequestParam("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 创建新用户
     * 通过POST请求体传入用户信息
     */
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 更新用户完整信息
     * 支持修改用户的所有属性
     */
    @PutMapping("update")
    public IResult update(UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 获取指定类型的用户列表
     *
     * @param type 用户类型，参考 {@link UserType} 枚举值
     * @prerequest groupA 需要groupA权限
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list(Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 通过路径参数获取指定类型的用户列表
     *
     * @param type 用户类型，参考 {@link UserType} 枚举值
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public IResult listTypeInPath(@PathVariable("type") Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        userInfo.setType(type);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 删除指定用户
     *
     * @param id 要删除的用户ID
     * @return 返回被删除的用户信息
     */
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 获取当前用户的类型
     * 随机返回一个用户类型，用于测试
     *
     * @return 返回用户类型的数值，参考 {@link com.itangcent.common.constant.UserTypeConstant}
     */
    @GetMapping("/type")
    public Result<Integer> currUserType() {
        return Result.success(UserType.values()[new Random(System.currentTimeMillis()).nextInt(UserType.values().length)].getType());
    }

    /**
     * 获取系统支持的所有用户类型
     *
     * @return 返回所有用户类型的列表，参考 {@link UserType#getType()}
     */
    @GetMapping("/types")
    public Result<List<Integer>> types() {
        final List<Integer> types = Stream.of(UserType.values()).map(UserType::getType).collect(Collectors.toList());
        return Result.success(types);
    }

    /**
     * 设置用户名和签名（旧版本）
     *
     * @param id      当前用户id - 从Cookie中获取
     * @param newName 新的用户名
     * @param slogon1 备用签名
     * @param slogon  主要签名
     * @tag a&zs, b, c 标签分类
     * @deprecated 建议使用新接口 {@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set")
    public Object setName(@CookieValue(value = "currentId", required = false, defaultValue = "123") long id,
                          String newName,
                          @RequestParam(required = false, name = "slogon2") String slogon1,
                          @RequestParam String slogon
    ) {

        UserInfo userInfo = new UserInfo();

        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

}
