package com.example.controller

import com.example.dto.PageResult
import com.example.dto.Result
import com.example.model.Category
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController {
    
    @GetMapping
    fun listCategories(
        @RequestParam(required = false) parentId: Long?,
        @RequestParam(required = false) level: Int?,
        @RequestParam(required = false) status: Int?
    ): Result<List<Category>> {
        val categories = listOf<Category>()
        return Result.success(categories)
    }
    
    @PostMapping
    fun createCategory(@RequestBody req: CreateCategoryReq): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Long): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody req: UpdateCategoryReq): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): Result<Void> {
        return Result.success(null)
    }
    
    @GetMapping("/tree")
    fun getCategoryTree(): Result<List<CategoryTreeVO>> {
        val tree = listOf<CategoryTreeVO>()
        return Result.success(tree)
    }
    
    @PutMapping("/{id}/move")
    fun moveCategory(@PathVariable id: Long, @RequestParam parentId: Long): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @PutMapping("/{id}/sort")
    fun updateSort(@PathVariable id: Long, @RequestParam sortOrder: Int): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @PutMapping("/{id}/status")
    fun updateStatus(@PathVariable id: Long, @RequestParam status: Int): Result<Category> {
        val category = Category()
        return Result.success(category)
    }
    
    @GetMapping("/{id}/products")
    fun getCategoryProducts(
        @PathVariable id: Long,
        @RequestParam(defaultValue = "1") pageNum: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ): Result<PageResult<Any>> {
        val result = PageResult<Any>()
        return Result.success(result)
    }
    
    @GetMapping("/{id}/children")
    fun getChildren(@PathVariable id: Long): Result<List<Category>> {
        val children = listOf<Category>()
        return Result.success(children)
    }
    
    @GetMapping("/{id}/parent")
    fun getParent(@PathVariable id: Long): Result<Category> {
        val parent = Category()
        return Result.success(parent)
    }
    
    @GetMapping("/{id}/path")
    fun getCategoryPath(@PathVariable id: Long): Result<List<Category>> {
        val path = listOf<Category>()
        return Result.success(path)
    }
    
    @PostMapping("/batch")
    fun batchCreate(@RequestBody reqs: List<CreateCategoryReq>): Result<List<Category>> {
        val categories = listOf<Category>()
        return Result.success(categories)
    }
    
    @DeleteMapping("/batch")
    fun batchDelete(@RequestBody ids: List<Long>): Result<Void> {
        return Result.success(null)
    }
    
    @GetMapping("/popular")
    fun getPopularCategories(@RequestParam(defaultValue = "10") limit: Int): Result<List<Category>> {
        val categories = listOf<Category>()
        return Result.success(categories)
    }
}

data class CreateCategoryReq(
    val name: String?,
    val parentId: Long?,
    val level: Int?,
    val sortOrder: Int?,
    val icon: String?
)

data class UpdateCategoryReq(
    val name: String?,
    val sortOrder: Int?,
    val icon: String?
)

data class CategoryTreeVO(
    val id: Long? = null,
    val name: String? = null,
    val parentId: Long? = null,
    val level: Int? = null,
    val icon: String? = null,
    val children: List<CategoryTreeVO>? = null
)
