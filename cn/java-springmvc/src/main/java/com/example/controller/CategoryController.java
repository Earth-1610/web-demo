package com.example.controller;

import org.springframework.web.bind.annotation.*;
import com.example.model.Category;
import com.example.dto.Result;
import com.example.dto.PageResult;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    @GetMapping
    public Result<List<Category>> listCategories(
            @RequestParam(required = false) Long parentId,
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) Integer status) {
        return Result.success(List.of());
    }
    
    @PostMapping
    public Result<Category> createCategory(@Valid @RequestBody CreateCategoryReq req) {
        return Result.success(new Category());
    }
    
    @GetMapping("/{id}")
    public Result<Category> getCategory(@PathVariable Long id) {
        return Result.success(new Category());
    }
    
    @PutMapping("/{id}")
    public Result<Category> updateCategory(@PathVariable Long id, @Valid @RequestBody UpdateCategoryReq req) {
        return Result.success(new Category());
    }
    
    @DeleteMapping("/{id}")
    public Result<Void> deleteCategory(@PathVariable Long id) {
        return Result.success(null);
    }
    
    @GetMapping("/tree")
    public Result<List<CategoryTreeVO>> getCategoryTree() {
        return Result.success(List.of());
    }
    
    @PutMapping("/{id}/move")
    public Result<Category> moveCategory(@PathVariable Long id, @RequestParam Long parentId) {
        return Result.success(new Category());
    }
    
    @PutMapping("/{id}/sort")
    public Result<Category> updateSort(@PathVariable Long id, @RequestParam Integer sortOrder) {
        return Result.success(new Category());
    }
    
    @PutMapping("/{id}/status")
    public Result<Category> updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        return Result.success(new Category());
    }
    
    @GetMapping("/{id}/products")
    public Result<PageResult<Object>> getCategoryProducts(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(new PageResult<>());
    }
    
    @GetMapping("/{id}/children")
    public Result<List<Category>> getChildren(@PathVariable Long id) {
        return Result.success(List.of());
    }
    
    @GetMapping("/{id}/parent")
    public Result<Category> getParent(@PathVariable Long id) {
        return Result.success(new Category());
    }
    
    @GetMapping("/{id}/path")
    public Result<List<Category>> getCategoryPath(@PathVariable Long id) {
        return Result.success(List.of());
    }
    
    @PostMapping("/batch")
    public Result<List<Category>> batchCreate(@Valid @RequestBody List<CreateCategoryReq> reqs) {
        return Result.success(List.of());
    }
    
    @DeleteMapping("/batch")
    public Result<Void> batchDelete(@RequestBody List<Long> ids) {
        return Result.success(null);
    }
    
    @GetMapping("/popular")
    public Result<List<Category>> getPopularCategories(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(List.of());
    }
}

class CreateCategoryReq {
    private String name;
    private Long parentId;
    private Integer level;
    private Integer sortOrder;
    private String icon;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }
    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}

class UpdateCategoryReq {
    private String name;
    private Integer sortOrder;
    private String icon;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}

class CategoryTreeVO {
    private Long id;
    private String name;
    private Long parentId;
    private Integer level;
    private String icon;
    private List<CategoryTreeVO> children;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }
    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public List<CategoryTreeVO> getChildren() { return children; }
    public void setChildren(List<CategoryTreeVO> children) { this.children = children; }
}
