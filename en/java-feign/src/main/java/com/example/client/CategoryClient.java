package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Category;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.util.List;

public interface CategoryClient {
    
    @RequestLine("GET /api/categories?parentId={parentId}&level={level}&status={status}")
    Result<List<Category>> listCategories(
            @Param("parentId") Long parentId,
            @Param("level") Integer level,
            @Param("status") Integer status);
    
    @RequestLine("POST /api/categories")
    Result<Category> createCategory(CreateCategoryReq req);
    
    @RequestLine("GET /api/categories/{id}")
    Result<Category> getCategory(@Param("id") Long id);
    
    @RequestLine("PUT /api/categories/{id}")
    Result<Category> updateCategory(@Param("id") Long id, UpdateCategoryReq req);
    
    @RequestLine("DELETE /api/categories/{id}")
    Result<Void> deleteCategory(@Param("id") Long id);
    
    @RequestLine("GET /api/categories/tree")
    Result<List<CategoryTreeVO>> getCategoryTree();
    
    @RequestLine("PUT /api/categories/{id}/move?parentId={parentId}")
    Result<Category> moveCategory(@Param("id") Long id, @Param("parentId") Long parentId);
    
    @RequestLine("PUT /api/categories/{id}/sort?sortOrder={sortOrder}")
    Result<Category> updateSort(@Param("id") Long id, @Param("sortOrder") Integer sortOrder);
    
    @RequestLine("PUT /api/categories/{id}/status?status={status}")
    Result<Category> updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    @RequestLine("GET /api/categories/{id}/products?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Object>> getCategoryProducts(
            @Param("id") Long id,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/categories/{id}/children")
    Result<List<Category>> getChildren(@Param("id") Long id);
    
    @RequestLine("GET /api/categories/{id}/parent")
    Result<Category> getParent(@Param("id") Long id);
    
    @RequestLine("GET /api/categories/{id}/path")
    Result<List<Category>> getCategoryPath(@Param("id") Long id);
    
    @RequestLine("POST /api/categories/batch")
    Result<List<Category>> batchCreate(List<CreateCategoryReq> reqs);
    
    @RequestLine("DELETE /api/categories/batch")
    Result<Void> batchDelete(List<Long> ids);
    
    @RequestLine("GET /api/categories/popular?limit={limit}")
    Result<List<Category>> getPopularCategories(@Param("limit") Integer limit);
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
