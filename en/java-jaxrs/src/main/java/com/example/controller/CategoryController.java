package com.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.example.model.Category;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.util.List;

@Path("/api/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {
    
    @GET
    public Response listCategories(
            @QueryParam("parentId") Long parentId,
            @QueryParam("level") Integer level,
            @QueryParam("status") Integer status) {
        List<Category> categories = List.of();
        return Response.ok(Result.success(categories)).build();
    }
    
    @POST
    public Response createCategory(CreateCategoryReq req) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getCategory(@PathParam("id") Long id) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateCategory(@PathParam("id") Long id, UpdateCategoryReq req) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") Long id) {
        return Response.ok(Result.success(null)).build();
    }
    
    @GET
    @Path("/tree")
    public Response getCategoryTree() {
        List<CategoryTreeVO> tree = List.of();
        return Response.ok(Result.success(tree)).build();
    }
    
    @PUT
    @Path("/{id}/move")
    public Response moveCategory(@PathParam("id") Long id, @QueryParam("parentId") Long parentId) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @PUT
    @Path("/{id}/sort")
    public Response updateSort(@PathParam("id") Long id, @QueryParam("sortOrder") Integer sortOrder) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @PUT
    @Path("/{id}/status")
    public Response updateStatus(@PathParam("id") Long id, @QueryParam("status") Integer status) {
        Category category = new Category();
        return Response.ok(Result.success(category)).build();
    }
    
    @GET
    @Path("/{id}/products")
    public Response getCategoryProducts(
            @PathParam("id") Long id,
            @QueryParam("pageNum") @DefaultValue("1") Integer pageNum,
            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        PageResult<Object> result = new PageResult<>();
        return Response.ok(Result.success(result)).build();
    }
    
    @GET
    @Path("/{id}/children")
    public Response getChildren(@PathParam("id") Long id) {
        List<Category> children = List.of();
        return Response.ok(Result.success(children)).build();
    }
    
    @GET
    @Path("/{id}/parent")
    public Response getParent(@PathParam("id") Long id) {
        Category parent = new Category();
        return Response.ok(Result.success(parent)).build();
    }
    
    @GET
    @Path("/{id}/path")
    public Response getCategoryPath(@PathParam("id") Long id) {
        List<Category> path = List.of();
        return Response.ok(Result.success(path)).build();
    }
    
    @POST
    @Path("/batch")
    public Response batchCreate(List<CreateCategoryReq> reqs) {
        List<Category> categories = List.of();
        return Response.ok(Result.success(categories)).build();
    }
    
    @DELETE
    @Path("/batch")
    public Response batchDelete(List<Long> ids) {
        return Response.ok(Result.success(null)).build();
    }
    
    @GET
    @Path("/popular")
    public Response getPopularCategories(@QueryParam("limit") @DefaultValue("10") Integer limit) {
        List<Category> categories = List.of();
        return Response.ok(Result.success(categories)).build();
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
