package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * User Management Controller (Deprecated)
 * This controller contains basic user management operations but has been marked as deprecated.
 * Recommended to use the new version {@link UserCtrl} instead.
 *
 * @module user
 * @deprecated This controller is deprecated, please use the new user controller
 */
@Deprecated
@RestController
@RequestMapping(value = "/user/deprecated")
public class DeprecatedUserCtrl {

    /**
     * Say hello
     * 
     * @return Returns a simple greeting message
     * @deprecated This method is deprecated, not recommended for continued use
     */
    @Deprecated
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * Update username
     * Updates user information by specifying user ID and new username
     *
     * @param id      User ID - Identifier of the user to update
     * @param newName New username - New name for the user
     * @return Returns updated user information
     * @deprecated Recommended to use {@link #update(UserInfo)} method instead, which provides more complete user information update functionality
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
     * Get user information
     * Queries and returns user's detailed information based on user ID
     *
     * @param id User ID - Identifier of the user to query
     * @return Returns response object containing user information
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
     * Add new user
     * Receives user information and creates a new user record
     *
     * @param userInfo User information object - Contains detailed information of the user to create
     * @return Returns the successfully created user information
     */
    @PostMapping("/add")
    public IResult add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Update user information
     * Receives complete user information object for update
     *
     * @param userInfo User information object - Contains complete information of the user to update
     * @return Returns the updated user information
     */
    @PutMapping("update")
    public IResult update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * Get user list
     * Returns the list of users in the system
     *
     * @return Returns response object containing user list
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
     * Delete user information
     * Deletes specified user's information based on user ID
     *
     * @param id User ID - Identifier of the user to delete
     * @return Returns the deleted user information
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
