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
 * User Management Controller
 * Provides operations for user information CRUD and related functions
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl extends BaseController {

    /**
     * Welcome API
     * Returns a simple greeting message
     */
    @Public
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * Update user basic information
     *
     * @param id      Current user ID - Retrieved from Cookie
     * @param newName New username
     * @param slogon  Personal signature
     * @param times   Operation count, default value is 10
     * @deprecated Recommend using new API {@link #update(UserInfo)}
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
     * Get user detailed information (Old version)
     *
     * @param id User ID - Passed through path parameter
     * @undone Interface to be improved
     * @see {@link #getById(Long)} Recommend using new version API
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
     * Get user information by user ID (New version)
     *
     * @param id User ID - Passed through request parameter
     * @undone Interface to be improved
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
     * Create new user
     * User information passed through POST request body
     */
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Update complete user information
     * Supports modification of all user properties
     */
    @PutMapping("update")
    public IResult update(UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Get user list of specified type
     *
     * @param type User type, refer to {@link UserType} enum values
     * @prerequest groupA Requires groupA permission
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
     * Get user list of specified type through path parameter
     *
     * @param type User type, refer to {@link UserType} enum values
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
     * Delete specified user
     *
     * @param id ID of the user to delete
     * @return Returns the deleted user information
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
     * Get current user type
     * Returns a random user type for testing purposes
     *
     * @return Returns user type value, refer to {@link com.itangcent.common.constant.UserTypeConstant}
     */
    @GetMapping("/type")
    public Result<Integer> currUserType() {
        return Result.success(UserType.values()[new Random(System.currentTimeMillis()).nextInt(UserType.values().length)].getType());
    }

    /**
     * Get all supported user types in the system
     *
     * @return Returns list of all user types, refer to {@link UserType#getType()}
     */
    @GetMapping("/types")
    public Result<List<Integer>> types() {
        final List<Integer> types = Stream.of(UserType.values()).map(UserType::getType).collect(Collectors.toList());
        return Result.success(types);
    }

    /**
     * Set username and signature (Old version)
     *
     * @param id      Current user ID - Retrieved from Cookie
     * @param newName New username
     * @param slogon1 Backup signature
     * @param slogon  Primary signature
     * @tag a&zs, b, c Tag categories
     * @deprecated Recommend using new API {@link #update(UserInfo)}
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
