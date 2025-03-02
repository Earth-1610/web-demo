package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.constant.UserType;
import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.dto.UserDtoWithEnum;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * Enum Type Test Controller
 * Demonstrates the usage of enum types in Spring MVC
 * Including enum handling in request body, request parameters, and path variables
 */
@RestController
@RequestMapping(value = "/test/enum")
public class TestEnumCtrl {

    /**
     * Enum field request body test
     * Demonstrates handling of enum type fields in request body
     *
     * @param userDtoWithEnum User DTO containing enum field
     * @return Returns processed user DTO (type set to ADMIN)
     * @public Marked as public interface
     */
    @RequestMapping("/echo")
    public UserDtoWithEnum echo(
            @RequestBody UserDtoWithEnum userDtoWithEnum) {
        userDtoWithEnum.setType(UserType.ADMIN);
        return userDtoWithEnum;
    }


    /**
     * Enum request parameter test
     * Demonstrates enum type handling with @RequestParam annotation
     *
     * @param type User type enum value
     * @return Returns user list of specified type
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
     * Enum path variable test
     * Demonstrates enum type handling with @PathVariable annotation
     *
     * @param type User type enum value (retrieved from URL path)
     * @return Returns user list of specified type
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
