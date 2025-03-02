package com.itangcent.springboot.demo.swagger.controller;

import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserInfo;
import com.itangcent.springboot.demo.swagger.dto.SwaggerModel;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/swagger")
@Api(value = "This is @Api swagger test SwaggerDemoController",
        tags = {"swagger test SwaggerDemoController"},
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerDemoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ApiOperation(value = "Greeting API")
    public String greeting() {
        return "hello world";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ApiOperation(value = "model")
    public SwaggerModel model() {
        return new SwaggerModel();
    }

    @ApiOperation(value = "Settings API", notes = "This is the settings API", tags = {"swagger", "test"})
    @RequestMapping(value = "/set/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 300, message = "This is the response", response = UserInfo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "implicitQuery", value = "An implicit parameter", defaultValue = "default name"),
            @ApiImplicitParam(name = "implicitHeader", paramType = "header", value = "An implicit header parameter", defaultValue = "implicit_header"),
            @ApiImplicitParam(name = "id", paramType = "path", value = "An implicit parameter", defaultValue = "implicit_path"),
            @ApiImplicitParam(name = "implicitForm", paramType = "form", value = "An implicit form parameter", defaultValue = "implicit_form")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Normal return"),
            @ApiResponse(code = 401, message = "No permission"),
            @ApiResponse(code = 403, message = "Still no permission")
    })
    @ApiImplicitParam(name = "implicit_query", value = "This is a hidden parameter", defaultValue = "implicit_query")
    public Object set(
            @ApiParam(value = "This is input ID", name = "This is param's name", defaultValue = "1") @PathVariable Long id,
            @ApiParam(value = "Input new name", defaultValue = "default name") @RequestParam(required = false) String newName,
            @ApiParam(value = "Input hahaha", required = true, defaultValue = "default none") @RequestParam(required = false, defaultValue = "haha") String slogon,
            @ApiParam(value = "Input times", defaultValue = "20") @RequestParam(required = false, defaultValue = "11") Long times) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }
} 