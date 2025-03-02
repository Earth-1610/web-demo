package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.constant.Add;
import com.itangcent.springboot.demo.common.constant.Update;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.ValidationDemoDto;
import com.itangcent.springboot.demo.common.model.ValidationGroupedDemoDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * 数据校验测试控制器
 * 演示Spring Validation框架的使用
 * 包括基本验证、分组验证和嵌套对象验证
 */
@RestController
@RequestMapping(value = "/test/validation")
public class ValidationCtrl {

    /**
     * 列表非空验证测试
     * 演示对请求体中List类型参数的非空验证
     *
     * @param ids 字符串ID列表，不能为空
     * @return 验证演示对象
     */
    @RequestMapping("/post-list")
    public ValidationDemoDto postList(
            @RequestBody @NotEmpty List<String> ids) {
        return null;
    }


    /**
     * 嵌套对象验证测试
     * 演示对包装在Result中的验证对象进行验证
     *
     * @param validationDemoDto 包含验证演示对象的Result
     * @return 验证演示对象
     */
    @RequestMapping("/demo")
    public ValidationDemoDto demo(
            @RequestBody Result<ValidationDemoDto> validationDemoDto) {
        return validationDemoDto.getData();
    }

    /**
     * 分组验证新增测试
     * 演示使用Add分组进行验证
     * 仅验证标记为Add组的字段
     *
     * @param validationGroupedDemoDto 带分组的验证对象
     */
    @RequestMapping("/demo/add")
    public void demoAdd(
            @Validated(Add.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }

    /**
     * 分组验证更新测试
     * 演示使用Update分组进行验证
     * 仅验证标记为Update组的字段
     *
     * @param validationGroupedDemoDto 带分组的验证对象
     */
    @RequestMapping("/demo/update")
    public void demoUpdate(
            @Validated(Update.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }
}
