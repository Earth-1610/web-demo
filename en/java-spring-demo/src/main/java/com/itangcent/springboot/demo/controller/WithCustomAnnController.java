package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserContent;
import com.itangcent.springboot.demo.common.annotation.UserContext;
import org.springframework.web.bind.annotation.*;

/**
 * Custom Annotation Parameter Processing Controller
 * Demonstrates how to handle custom annotations and system auto-filled parameters
 * Shows parameter ignore rules in API documentation
 */
@RestController
@RequestMapping("/testParamsWithCustomAnno")
public class WithCustomAnnController {

    /**
     * Custom annotation parameter test
     * Demonstrates auto-injection of user context using @UserContext annotation
     *
     * @param paramShouldNotIgnore Regular request parameter, will be shown in API documentation
     * @param userContent User context object (auto-injected by system, ignored in API documentation)
     * @return Returns processing result
     */
    @PostMapping("/custom/ann")
    public IResult testParamsWithCustomAnno(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @UserContext UserContent userContent) {
        return Result.success("ok");
    }

    /**
     * Auto-fill token test
     * Demonstrates system automatic handling of token in request header
     *
     * @param paramShouldNotIgnore Regular request parameter, will be shown in API documentation
     * @param token Authentication token (auto-retrieved by system, ignored in API documentation)
     * @return Returns processing result
     */
    @PostMapping("/auto/fill/token")
    public IResult testAutoFillToken(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @RequestHeader("token") String token) {
        return Result.success("ok");
    }
}
