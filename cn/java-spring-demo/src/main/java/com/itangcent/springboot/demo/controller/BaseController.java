package com.itangcent.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基础控制器类
 * 提供所有控制器通用的基本功能
 */
public class BaseController {

    /**
     * 获取当前控制器的类名
     * 用于调试和监控目的
     * 
     * @return 返回当前控制器的完全限定类名
     * @public 表示此API为公开接口
     */
    @RequestMapping("/ctrl/name")
    public String ctrlName() {
        return getClass().getName();
    }
}
