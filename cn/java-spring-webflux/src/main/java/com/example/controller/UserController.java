package com.example.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import com.example.model.User;
import com.example.dto.Result;
import com.example.dto.PageResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @GetMapping
    public Mono<Result<PageResult<User>>> listUsers(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer status,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Mono.just(Result.success(new PageResult<>()));
    }
    
    @PostMapping
    public Mono<Result<User>> createUser(@Valid @RequestBody CreateUserReq req) {
        return Mono.just(Result.success(new User()));
    }
    
    @GetMapping("/{id}")
    public Mono<Result<User>> getUser(@PathVariable Long id) {
        return Mono.just(Result.success(new User()));
    }
    
    @PutMapping("/{id}")
    public Mono<Result<User>> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserReq req) {
        return Mono.just(Result.success(new User()));
    }
    
    @DeleteMapping("/{id}")
    public Mono<Result<Void>> deleteUser(@PathVariable Long id) {
        return Mono.just(Result.success(null));
    }
}

class CreateUserReq {
    private String username;
    private String email;
    private String password;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class UpdateUserReq {
    private String username;
    private String email;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
