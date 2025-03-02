package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 测试控制器
 * 提供各种HTTP请求测试的示例接口
 */
@RestController
@RequestMapping(value = ["/test"])
class TestCtrl {

    /**
     * 测试请求头参数
     * 演示如何获取和处理HTTP请求头中的参数
     *
     * @param token 请求头中的token值
     * @return 返回接收到的token值
     */
    @RequestMapping("/header")
    fun header(
            @RequestHeader("token") token: String): String {
        return token
    }

    /**
     * 测试数组类型参数
     * 演示如何处理多个字符串和整数数组参数
     *
     * @param strings 字符串数组参数
     * @param ints 整数数组参数
     * @return 固定返回"ok"
     */
    @RequestMapping("/arrays")
    fun header(@RequestParam(name = "string") strings: Array<String>,
               @RequestParam(name = "int") ints: IntArray): String {
        return "ok"
    }

    /**
     * 被忽略的测试方法
     * 此方法将被API文档生成工具忽略
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    fun ignore(): String {
        return "ignore"
    }

    /**
     * 测试HttpServletRequest对象
     * 演示如何在控制器中使用原生的HttpServletRequest对象
     */
    @RequestMapping("/httpServletRequest")
    fun request(httpServletRequest: HttpServletRequest): String {
        return "javax.servlet.http.HttpServletRequest"
    }

    /**
     * 测试HttpServletResponse对象
     * 演示如何在控制器中使用原生的HttpServletResponse对象
     */
    @RequestMapping("/httpServletResponse")
    fun response(httpServletResponse: HttpServletResponse): String {
        return "javax.servlet.http.HttpServletResponse"
    }

    /**
     * 测试复杂集合类型响应
     * 演示如何返回包含嵌套Map的List集合数据
     *
     * @param id 用户ID
     * @return 返回包含测试数据的复杂集合结构
     */
    @RequestMapping(value = ["/interWithCollection"], method = [RequestMethod.POST])
    fun interWithCollection(@PathVariable("id") id: Long?): IResult<List<Map<String, Any>>> {
        val list = LinkedList<Map<String, Any>>()
        val map = HashMap<String, Any>()
        map["key1"] = "string"//这是个测试的key
        map["key2"] = 666//这是个测试的666
        val value3 = HashMap<String, Any>()
        value3["subKey"] = "string"//这是个测试的子对象的key
        map["key3"] = value3//这是个测试的子对象
        list.add(map)
        return Result.success(list)
    }
}
