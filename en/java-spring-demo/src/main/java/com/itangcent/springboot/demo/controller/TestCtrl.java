package com.itangcent.springboot.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Node;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.TestBean;
import com.itangcent.springboot.demo.common.annotation.CustomRestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Test Controller
 * Provides test APIs for various Spring MVC features, used for demonstrating and testing framework capabilities.
 * Including:
 * - Parameter binding (headers, arrays, path variables, etc.)
 * - Response types (void, Void, custom objects, etc.)
 * - Request handling (POST, GET methods, etc.)
 * - Advanced features (JsonView, pagination, etc.)
 *
 * @module test
 */
@CustomRestController
@RequestMapping(value = "/test")
public class TestCtrl extends BaseController {

    /**
     * POST request test without parameters
     * Demonstrates the simplest POST request handling, returns result without accepting any parameters
     * 
     * @return Returns fixed string "postWithoutParam"
     */
    @RequestMapping(value = "/postWithoutParam", method = RequestMethod.POST)
    public String postWithoutParam() {
        return "postWithoutParam";
    }

    /**
     * Request header parameter test
     * Demonstrates how to get parameters from HTTP request headers, commonly used in authentication scenarios
     *
     * @param token Token value from request header - Retrieved using @RequestHeader annotation
     * @return Returns the received token value for verification
     * @export Marked as exported API
     */
    @RequestMapping("/header")
    public String header(
            @RequestHeader("token") String token) {
        return token;
    }

    /**
     * Array parameters test
     * Demonstrates how to handle array type request parameters, supports multiple value parameters
     *
     * @param strings String array parameter - String array passed through URL parameters
     * @param ints Integer array parameter - Integer array passed through URL parameters
     * @return Returns fixed "ok" to indicate successful processing
     * @export Marked as exported API
     */
    @RequestMapping("/arrays")
    public String header(@RequestParam(name = "string") String[] strings,
                         @RequestParam(name = "int") int[] ints) {
        return "ok";
    }

    /**
     * Ignored test method
     * This method won't be processed by API documentation tools, demonstrates the ignore feature
     *
     * @ignore Marked as ignored, won't appear in API documentation
     */
    @RequestMapping("/ignore")
    public String ignore() {
        return "ignore";
    }

    /**
     * HttpServletRequest object test
     * Demonstrates how to use native Servlet request object, for scenarios requiring access to low-level request information
     *
     * @param httpServletRequest Servlet request object - Contains complete HTTP request information
     * @return Returns object type description string
     */
    @RequestMapping("/httpServletRequest")
    public String request(HttpServletRequest httpServletRequest) {
        httpServletRequest.getAuthType();
        return "javax.servlet.http.HttpServletRequest";
    }

    /**
     * HttpServletResponse object test
     * Demonstrates how to use native Servlet response object, for scenarios requiring precise control over HTTP response
     *
     * @param httpServletResponse Servlet response object - Used for customizing HTTP response
     * @return Returns object type description string
     */
    @RequestMapping("/httpServletResponse")
    public String response(HttpServletResponse httpServletResponse) {
        return "javax.servlet.http.HttpServletResponse";
    }

    /**
     * Complex collection response test
     * Demonstrates how to return a List containing nested Maps, showing complex data structure serialization
     *
     * @param id Path parameter ID - Used to identify the requested resource
     * @return Response object containing complex data structure, including:
     *         - key1: String type
     *         - key2: Number type
     *         - key3: Map containing sub-objects
     */
    @RequestMapping(value = "/interWithCollection", method = RequestMethod.POST)
    public IResult interWithCollection(@PathVariable("id") Long id) {
        List<Map> list = new LinkedList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "string");// This is a test key
        map.put("key2", 666);// This is a test value 666
        Map<String, Object> value3 = new HashMap<>();
        value3.put("subKey", "string");// This is a test key for sub-object
        map.put("key3", value3);// This is a test sub-object
        list.add(map);
        return Result.success(list);
    }

    /**
     * void return type test
     * Demonstrates request handling without return value, for scenarios where only operation execution is needed
     */
    @RequestMapping("/return/void")
    public void returnvoid() {
        return;
    }

    /**
     * Void object return test
     * Demonstrates returning Void type object, differs from void as this is an object type
     */
    @RequestMapping("/return/Void")
    public Void returnVoid() {
        return null;
    }

    /**
     * Result<Void> return test
     * Demonstrates returning Result wrapper object with no data, for scenarios requiring unified return format but no data
     */
    @RequestMapping("/return/result/Void")
    public Result<Void> returnResultVoid() {
        return null;
    }

    /**
     * Node object return test
     * Demonstrates returning tree node object, for testing custom object serialization
     */
    @RequestMapping("/return/node")
    public Result<Node> returnNode() {
        return null;
    }

    /**
     * List request body test
     * Demonstrates how to handle List type request body, for batch operation scenarios
     *
     * @param ids Integer ID list - Cannot be empty, validated using @NotEmpty annotation
     * @return Returns node object, demonstrating processing result
     */
    @RequestMapping("/body/list")
    public Result<Node> bodyList(@RequestBody @NotEmpty List<Integer> ids) {
        return null;
    }

    /**
     * JsonView view A test
     * Demonstrates Jackson's @JsonView annotation functionality, implementing selective field serialization
     * Only returns fields marked as ViewA, used to control field display in API response
     */
    @GetMapping("/testJsonViewA")
    @JsonView(TestBean.ViewA.class)
    public TestBean testJsonViewA() {
        TestBean testBean = new TestBean();
        return testBean;
    }

    /**
     * Page object test
     * Demonstrates MyBatis-Plus pagination object usage
     *
     * @param request Page request object
     * @return Page response object
     */
    @GetMapping("/testPage")
    public Page<Integer> testPage(Page<Integer> request) {
        return request;
    }
}
