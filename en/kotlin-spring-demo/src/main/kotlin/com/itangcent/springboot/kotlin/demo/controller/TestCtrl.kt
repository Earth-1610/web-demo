package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Test Controller
 * Provides example interfaces for testing various HTTP requests
 */
@RestController
@RequestMapping(value = ["/test"])
class TestCtrl {

    /**
     * Test Request Header Parameters
     * Demonstrates how to get and process parameters from HTTP request headers
     *
     * @param token Token value from request header
     * @return Returns the received token value
     */
    @RequestMapping("/header")
    fun header(
            @RequestHeader("token") token: String): String {
        return token
    }

    /**
     * Test Array Type Parameters
     * Demonstrates how to handle multiple string and integer array parameters
     *
     * @param strings String array parameter
     * @param ints Integer array parameter
     * @return Returns fixed "ok" string
     */
    @RequestMapping("/arrays")
    fun header(@RequestParam(name = "string") strings: Array<String>,
               @RequestParam(name = "int") ints: IntArray): String {
        return "ok"
    }

    /**
     * Ignored Test Method
     * This method will be ignored by API documentation generation tools
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    fun ignore(): String {
        return "ignore"
    }

    /**
     * Test HttpServletRequest Object
     * Demonstrates how to use the native HttpServletRequest object in controllers
     */
    @RequestMapping("/httpServletRequest")
    fun request(httpServletRequest: HttpServletRequest): String {
        return "javax.servlet.http.HttpServletRequest"
    }

    /**
     * Test HttpServletResponse Object
     * Demonstrates how to use the native HttpServletResponse object in controllers
     */
    @RequestMapping("/httpServletResponse")
    fun response(httpServletResponse: HttpServletResponse): String {
        return "javax.servlet.http.HttpServletResponse"
    }

    /**
     * Test Complex Collection Type Response
     * Demonstrates how to return a List collection data containing nested Maps
     *
     * @param id User ID
     * @return Returns the complex collection structure containing test data
     */
    @RequestMapping(value = ["/interWithCollection"], method = [RequestMethod.POST])
    fun interWithCollection(@PathVariable("id") id: Long?): IResult<List<Map<String, Any>>> {
        val list = LinkedList<Map<String, Any>>()
        val map = HashMap<String, Any>()
        map["key1"] = "string"//This is a test key
        map["key2"] = 666//This is a test 666
        val value3 = HashMap<String, Any>()
        value3["subKey"] = "string"//This is a test subobject key
        map["key3"] = value3//This is a test subobject
        list.add(map)
        return Result.success(list)
    }
}
