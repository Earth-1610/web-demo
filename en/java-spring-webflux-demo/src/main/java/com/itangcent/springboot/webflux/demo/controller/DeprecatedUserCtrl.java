package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * User Related Operations (Deprecated)
 *
 * @module user
 */
@Deprecated
@RestController
@RequestMapping(value = "/user/deprecated")
public class DeprecatedUserCtrl {

    /**
     * Say Hello
     */
    @Deprecated
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * Update Username
     *
     * @param id User ID
     * @param newName New username
     * @deprecated Use {@link #update(UserInfo)} instead
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
     * Get User Information
     *
     * @param id User ID
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
     * Add New User
     */
    @PostMapping("/add")
    public IResult add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Update User Information
     */
    @PutMapping("update")
    public IResult update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Get User List
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * Delete User Information
     *
     * @param id User ID
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
