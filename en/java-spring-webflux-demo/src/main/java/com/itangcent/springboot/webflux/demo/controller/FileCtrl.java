package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.dto.UserDto;
import com.itangcent.common.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * User Related Operations (with File Attachments)
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
@Slf4j
public class FileCtrl {
    /**
     * Add New User (Upload Profile Picture)
     */
    @PostMapping("/add")
    public Mono<IResult> add(@ModelAttribute UserDto userDto) {
        return Mono.just(Result.success("Save successful"));
    }

    /**
     * Alternative Method to Add New User (Upload Profile Picture)
     * File as a separate parameter
     *
     * @undone
     */
    @PostMapping("/add2")
    public Mono<IResult> add(UserInfo userInfo,
                             @RequestParam(name = "profileImg") MultipartFile profileImg) {
        return Mono.just(Result.success("Save successful"));
    }

    /**
     * Try Uploading Multiple Profile Pictures
     *
     * @undone
     */
    @PostMapping("/add3")
    public Mono<IResult> add(UserInfo userInfo,
                             @RequestParam(name = "profileImg") MultipartFile[] profileImgs) {
        return Mono.just(Result.success("Save successful"));
    }
}
