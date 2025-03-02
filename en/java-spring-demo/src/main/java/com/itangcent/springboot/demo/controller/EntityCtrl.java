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
 * Spring Entity Test Controller
 * Demonstrates the usage of various Entity objects provided by Spring
 * Including RequestEntity, ResponseEntity, and HttpEntity
 */
@RestController
@RequestMapping(value = "/test/entity")
public class EntityCtrl extends BaseController {

    /**
     * Integer type ResponseEntity test
     * Demonstrates how to use ResponseEntity to wrap primitive type response
     *
     * @param token Token from request header
     * @param requestEntity Request entity containing integer
     * @return Response entity containing integer
     * @public Marked as public interface
     */
    @RequestMapping("/int")
    public ResponseEntity<Integer> intInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<Integer> requestEntity) {
        return ResponseEntity.ok(65536);
    }

    /**
     * Non-generic ResponseEntity test
     * Demonstrates usage of ResponseEntity without specifying generic type
     *
     * @return Response entity containing string
     * @public Marked as public interface
     */
    @RequestMapping("/nil")
    public ResponseEntity nilEntity() {
        return ResponseEntity.ok("nil");
    }

    /**
     * Complex object ResponseEntity test
     * Demonstrates ResponseEntity wrapping Result<Double> object
     *
     * @param token Token from request header
     * @param requestEntity Request entity containing user information
     * @return Result response entity containing double value
     * @public Marked as public interface
     */
    @RequestMapping("/double")
    public ResponseEntity<Result<Double>> doubleInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<UserInfo> requestEntity) {
        return ResponseEntity.ok(Result.success(65536.0));
    }

    /**
     * HttpEntity test
     * Demonstrates HttpEntity wrapping user information response
     *
     * @param token Token from request header
     * @return Result response entity containing user information
     */
    @RequestMapping("/user")
    public HttpEntity<Result<UserInfo>> userInEntity(
            @RequestHeader("token") String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        return ResponseEntity.ok(Result.success(userInfo));
    }

}
