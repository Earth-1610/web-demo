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
 * Data Validation Test Controller
 * Demonstrates the usage of Spring Validation framework
 * Including basic validation, group validation, and nested object validation
 */
@RestController
@RequestMapping(value = "/test/validation")
public class ValidationCtrl {

    /**
     * List non-empty validation test
     * Demonstrates non-empty validation for List type parameters in request body
     *
     * @param ids String ID list, cannot be empty
     * @return Validation demo object
     */
    @RequestMapping("/post-list")
    public ValidationDemoDto postList(
            @RequestBody @NotEmpty List<String> ids) {
        return null;
    }


    /**
     * Nested object validation test
     * Demonstrates validation for validation object wrapped in Result
     *
     * @param validationDemoDto Result containing validation demo object
     * @return Validation demo object
     */
    @RequestMapping("/demo")
    public ValidationDemoDto demo(
            @RequestBody Result<ValidationDemoDto> validationDemoDto) {
        return validationDemoDto.getData();
    }

    /**
     * Group validation add test
     * Demonstrates validation using Add group
     * Only validates fields marked with Add group
     *
     * @param validationGroupedDemoDto Validation object with groups
     */
    @RequestMapping("/demo/add")
    public void demoAdd(
            @Validated(Add.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }

    /**
     * Group validation update test
     * Demonstrates validation using Update group
     * Only validates fields marked with Update group
     *
     * @param validationGroupedDemoDto Validation object with groups
     */
    @RequestMapping("/demo/update")
    public void demoUpdate(
            @Validated(Update.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }
}
