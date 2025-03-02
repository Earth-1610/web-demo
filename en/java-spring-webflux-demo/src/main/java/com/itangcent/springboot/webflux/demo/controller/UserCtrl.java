package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * User Management Controller
 * Provides basic CRUD operations for user information
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl {

    /**
     * Welcome Interface
     * Returns a simple greeting message
     *
     * @return Greeting message
     */
    @RequestMapping(value = "/index")
    public Mono<String> greeting() {
        return Mono.just("hello world");
    }

    /**
     * Update User Name
     * Updates user's name and other information based on user ID
     *
     * @param id User ID
     * @param newName New user name
     * @param slogon Personal signature
     * @param times Operation count
     * @return Updated user information
     * @deprecated Please use {@link #update(UserInfo)} instead
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
     * Get User Information
     * Queries detailed user information by user ID
     *
     * @param id User ID
     * @return User information
     * @deprecated This interface is deprecated, please use the new query interface
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
     * Create New User
     * Adds a new user information to the system
     *
     * @param userInfo User information object
     * @return Creation result, including new user information
     */
    @PostMapping("/add")
    public Mono<Result<UserInfo>> add(@RequestBody UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * Update User Information
     * Updates all information for the specified user
     *
     * @param userInfo Updated user information
     * @return Update result
     */
    @PutMapping("/update")
    public Mono<IResult> update(@ModelAttribute UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * Get User List
     * Queries information for all users in the system
     *
     * @return User list
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
     * Delete User
     * Deletes user information based on user ID
     *
     * @param id User ID to delete
     * @return Deletion result, including deleted user information
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
