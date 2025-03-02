package com.itangcent.springboot.demo.controller;


import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Spring Entity对象测试控制器
 * 演示Spring提供的各种Entity对象的使用
 * 包括RequestEntity、ResponseEntity和HttpEntity
 */
@RestController
@RequestMapping(value = "/test/entity")
public class EntityCtrl extends BaseController {

    /**
     * 整数类型ResponseEntity测试
     * 演示如何使用ResponseEntity包装基本类型响应
     *
     * @param token 请求头中的token
     * @param requestEntity 包含整数的请求实体
     * @return 包含整数的响应实体
     * @public 标记为公开接口
     */
    @RequestMapping("/int")
    public ResponseEntity<Integer> intInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<Integer> requestEntity) {
        return ResponseEntity.ok(65536);
    }

    /**
     * 无泛型ResponseEntity测试
     * 演示不指定泛型类型的ResponseEntity使用
     *
     * @return 包含字符串的响应实体
     * @public 标记为公开接口
     */
    @RequestMapping("/nil")
    public ResponseEntity nilEntity() {
        return ResponseEntity.ok("nil");
    }

    /**
     * 复合对象ResponseEntity测试
     * 演示ResponseEntity包装Result<Double>对象
     *
     * @param token 请求头中的token
     * @param requestEntity 包含用户信息的请求实体
     * @return 包含浮点数的Result响应实体
     * @public 标记为公开接口
     */
    @RequestMapping("/double")
    public ResponseEntity<Result<Double>> doubleInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<UserInfo> requestEntity) {
        return ResponseEntity.ok(Result.success(65536.0));
    }

    /**
     * HttpEntity测试
     * 演示HttpEntity包装用户信息响应
     *
     * @param token 请求头中的token
     * @return 包含用户信息的Result响应实体
     */
    @RequestMapping("/user")
    public HttpEntity<Result<UserInfo>> userInEntity(
            @RequestHeader("token") String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        return ResponseEntity.ok(Result.success(userInfo));
    }

}
