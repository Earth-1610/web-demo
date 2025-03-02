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
 * 测试控制器
 * 提供各种Spring MVC功能的测试接口，用于演示和测试框架的各种特性。
 * 包括：
 * - 参数绑定（请求头、数组、路径变量等）
 * - 响应类型（void、Void、自定义对象等）
 * - 请求处理（POST、GET等方法）
 * - 高级特性（JsonView、分页等）
 *
 * @module test
 */
@CustomRestController
@RequestMapping(value = "/test")
public class TestCtrl extends BaseController {

    /**
     * 无参数POST请求测试
     * 演示最简单的POST请求处理方式，不接收任何参数直接返回结果
     * 
     * @return 返回固定字符串"postWithoutParam"
     */
    @RequestMapping(value = "/postWithoutParam", method = RequestMethod.POST)
    public String postWithoutParam() {
        return "postWithoutParam";
    }

    /**
     * 请求头参数测试
     * 演示如何获取HTTP请求头中的参数，常用于身份验证等场景
     *
     * @param token 从请求头获取的token值 - 使用@RequestHeader注解获取
     * @return 返回收到的token值，用于验证是否正确获取
     * @export 标记为导出接口
     */
    @RequestMapping("/header")
    public String header(
            @RequestHeader("token") String token) {
        return token;
    }

    /**
     * 数组参数测试
     * 演示如何处理数组类型的请求参数，支持多值参数的处理
     *
     * @param strings 字符串数组参数 - 通过URL参数传递的字符串数组
     * @param ints 整数数组参数 - 通过URL参数传递的整数数组
     * @return 固定返回"ok"表示处理成功
     * @export 标记为导出接口
     */
    @RequestMapping("/arrays")
    public String header(@RequestParam(name = "string") String[] strings,
                         @RequestParam(name = "int") int[] ints) {
        return "ok";
    }

    /**
     * 忽略的测试方法
     * 此方法不会被API文档工具处理，用于演示文档工具的忽略功能
     *
     * @ignore 标记为忽略，不会出现在API文档中
     */
    @RequestMapping("/ignore")
    public String ignore() {
        return "ignore";
    }

    /**
     * HttpServletRequest对象测试
     * 演示如何使用原生Servlet请求对象，用于需要访问底层请求信息的场景
     *
     * @param httpServletRequest Servlet请求对象 - 包含完整的HTTP请求信息
     * @return 返回对象类型的描述字符串
     */
    @RequestMapping("/httpServletRequest")
    public String request(HttpServletRequest httpServletRequest) {
        httpServletRequest.getAuthType();
        return "javax.servlet.http.HttpServletRequest";
    }

    /**
     * HttpServletResponse对象测试
     * 演示如何使用原生Servlet响应对象，用于需要精确控制HTTP响应的场景
     *
     * @param httpServletResponse Servlet响应对象 - 用于自定义HTTP响应
     * @return 返回对象类型的描述字符串
     */
    @RequestMapping("/httpServletResponse")
    public String response(HttpServletResponse httpServletResponse) {
        return "javax.servlet.http.HttpServletResponse";
    }

    /**
     * 复杂集合响应测试
     * 演示如何返回包含嵌套Map的List集合，展示复杂数据结构的序列化
     *
     * @param id 路径参数ID - 用于标识请求的资源
     * @return 包含复杂数据结构的响应对象，包括：
     *         - key1: 字符串类型
     *         - key2: 数字类型
     *         - key3: 包含子对象的Map
     */
    @RequestMapping(value = "/interWithCollection", method = RequestMethod.POST)
    public IResult interWithCollection(@PathVariable("id") Long id) {
        List<Map> list = new LinkedList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "string");//这是个测试的key
        map.put("key2", 666);//这是个测试的666
        Map<String, Object> value3 = new HashMap<>();
        value3.put("subKey", "string");//这是个测试的子对象的key
        map.put("key3", value3);//这是个测试的子对象
        list.add(map);
        return Result.success(list);
    }

    /**
     * void返回值测试
     * 演示无返回值的请求处理，用于只需执行操作不需要返回数据的场景
     */
    @RequestMapping("/return/void")
    public void returnvoid() {
        return;
    }

    /**
     * Void对象返回测试
     * 演示返回Void类型对象，与void的区别在于这是一个对象类型
     */
    @RequestMapping("/return/Void")
    public Void returnVoid() {
        return null;
    }

    /**
     * Result<Void>返回测试
     * 演示返回空数据的Result包装对象，用于统一返回格式但不需要数据的场景
     */
    @RequestMapping("/return/result/Void")
    public Result<Void> returnResultVoid() {
        return null;
    }

    /**
     * Node对象返回测试
     * 演示返回树节点对象，用于测试自定义对象的序列化
     */
    @RequestMapping("/return/node")
    public Result<Node> returnNode() {
        return null;
    }

    /**
     * List请求体测试
     * 演示如何处理List类型的请求体，用于批量操作场景
     *
     * @param ids 整数ID列表 - 不能为空，使用@NotEmpty注解验证
     * @return 返回节点对象，演示处理结果
     */
    @RequestMapping("/body/list")
    public Result<Node> bodyList(@RequestBody @NotEmpty List<Integer> ids) {
        return null;
    }

    /**
     * JsonView视图A测试
     * 演示Jackson的@JsonView注解功能，实现字段的选择性序列化
     * 只返回标记为ViewA的字段，用于控制API响应中的字段显示
     */
    @GetMapping("/testJsonViewA")
    @JsonView(TestBean.ViewA.class)
    public TestBean testJsonViewA() {
        TestBean testBean = new TestBean();
        return testBean;
    }

    /**
     * 分页对象测试
     * 演示MyBatis-Plus的分页对象使用
     *
     * @param request 分页请求对象
     * @return 分页响应对象
     */
    @GetMapping("/testPage")
    public Page<Integer> testPage(Page<Integer> request) {
        return request;
    }
}
