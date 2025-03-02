package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * 用户相关控制器(已废弃)
 * 此控制器包含了用户管理的基本操作，但已被标记为废弃。
 * 建议使用新版本的 {@link UserCtrl} 替代。
 *
 * @module user
 * @deprecated 此控制器已废弃，请使用新版本的用户控制器
 */
@Deprecated
@RestController
@RequestMapping(value = "/user/deprecated")
public class DeprecatedUserCtrl {

    /**
     * 打个招呼
     * 
     * @return 返回简单的问候语
     * @deprecated 此方法已废弃，不建议继续使用
     */
    @Deprecated
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * 更新用户名
     * 通过指定用户ID和新用户名来更新用户信息
     *
     * @param id      用户id - 要更新的用户标识
     * @param newName 新的用户名 - 用户的新名称
     * @return 返回更新后的用户信息
     * @deprecated 建议使用 {@link #update(UserInfo)} 方法替代，该方法提供更完整的用户信息更新功能
     */
    @Deprecated
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Object set(Long id, String newName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 获取用户信息
     * 根据用户ID查询并返回用户的详细信息
     *
     * @param id 用户id - 要查询的用户标识
     * @return 返回包含用户信息的响应对象
     */
    @GetMapping("/get/{id}")
    public IResult get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 增加新用户
     * 接收用户信息并创建新的用户记录
     *
     * @param userInfo 用户信息对象 - 包含要创建的用户的详细信息
     * @return 返回创建成功的用户信息
     */
    @PostMapping("/add")
    public IResult add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 更新用户信息
     * 接收完整的用户信息对象进行更新
     *
     * @param userInfo 用户信息对象 - 包含要更新的用户的完整信息
     * @return 返回更新后的用户信息
     */
    @PutMapping("update")
    public IResult update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 获取用户列表
     * 返回系统中的用户列表信息
     *
     * @return 返回包含用户列表的响应对象
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 删除用户信息
     * 根据用户ID删除指定用户的信息
     *
     * @param id 用户id - 要删除的用户标识
     * @return 返回被删除的用户信息
     */
    @DeleteMapping("/{id}")
    public IResult delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

}
