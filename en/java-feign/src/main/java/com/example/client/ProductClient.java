package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Product;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.math.BigDecimal;
import java.util.List;

public interface ProductClient {
    
    @RequestLine("GET /api/products?keyword={keyword}&categoryId={categoryId}&minPrice={minPrice}&maxPrice={maxPrice}&status={status}&pageNum={pageNum}&pageSize={pageSize}&sortBy={sortBy}&sortOrder={sortOrder}")
    Result<PageResult<Product>> listProducts(
            @Param("keyword") String keyword,
            @Param("categoryId") Long categoryId,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize,
            @Param("sortBy") String sortBy,
            @Param("sortOrder") String sortOrder);
    
    @RequestLine("POST /api/products")
    Result<Product> createProduct(CreateProductReq req);
    
    @RequestLine("GET /api/products/{id}")
    Result<Product> getProduct(@Param("id") Long id);
    
    @RequestLine("PUT /api/products/{id}")
    Result<Product> updateProduct(@Param("id") Long id, UpdateProductReq req);
    
    @RequestLine("DELETE /api/products/{id}")
    Result<Void> deleteProduct(@Param("id") Long id);
    
    @RequestLine("GET /api/products/search?keyword={keyword}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Product>> searchProducts(
            @Param("keyword") String keyword,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/products/category/{categoryId}?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Product>> getProductsByCategory(
            @Param("categoryId") Long categoryId,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/products/hot?limit={limit}")
    Result<List<Product>> getHotProducts(@Param("limit") Integer limit);
    
    @RequestLine("GET /api/products/new?limit={limit}")
    Result<List<Product>> getNewProducts(@Param("limit") Integer limit);
    
    @RequestLine("GET /api/products/recommended?userId={userId}&limit={limit}")
    Result<List<Product>> getRecommendedProducts(
            @Param("userId") Long userId,
            @Param("limit") Integer limit);
    
    @RequestLine("PUT /api/products/{id}/stock?stock={stock}")
    Result<Product> updateStock(@Param("id") Long id, @Param("stock") Integer stock);
    
    @RequestLine("GET /api/products/{id}/inventory")
    Result<InventoryVO> getInventory(@Param("id") Long id);
    
    @RequestLine("GET /api/products/{id}/reviews?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<ReviewVO>> getProductReviews(
            @Param("id") Long id,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/products/{id}/statistics")
    Result<ProductStatisticsVO> getStatistics(@Param("id") Long id);
    
    @RequestLine("PUT /api/products/{id}/status?status={status}")
    Result<Product> updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    @RequestLine("PUT /api/products/{id}/price?price={price}")
    Result<Product> updatePrice(@Param("id") Long id, @Param("price") BigDecimal price);
    
    @RequestLine("PUT /api/products/{id}/discount?originalPrice={originalPrice}&discountPrice={discountPrice}")
    Result<Product> updateDiscount(
            @Param("id") Long id,
            @Param("originalPrice") BigDecimal originalPrice,
            @Param("discountPrice") BigDecimal discountPrice);
    
    @RequestLine("GET /api/products/{id}/related?limit={limit}")
    Result<List<Product>> getRelatedProducts(@Param("id") Long id, @Param("limit") Integer limit);
    
    @RequestLine("GET /api/products/sku/{skuId}")
    Result<Product> getProductBySku(@Param("skuId") String skuId);
    
    @RequestLine("POST /api/products/batch")
    Result<List<Product>> batchCreate(List<CreateProductReq> reqs);
    
    @RequestLine("PUT /api/products/batch")
    Result<List<Product>> batchUpdate(List<UpdateProductReq> reqs);
    
    @RequestLine("DELETE /api/products/batch")
    Result<Void> batchDelete(List<Long> ids);
    
    @RequestLine("GET /api/products/export?categoryId={categoryId}")
    Result<String> exportProducts(@Param("categoryId") Long categoryId);
    
    @RequestLine("GET /api/products/{id}/specs")
    Result<List<ProductSpecVO>> getProductSpecs(@Param("id") Long id);
    
    @RequestLine("POST /api/products/{id}/specs")
    Result<ProductSpecVO> addProductSpec(@Param("id") Long id, CreateSpecReq req);
    
    @RequestLine("DELETE /api/products/{id}/specs/{specId}")
    Result<Void> deleteProductSpec(@Param("id") Long id, @Param("specId") Long specId);
    
    @RequestLine("GET /api/products/{id}/tags")
    Result<List<TagVO>> getProductTags(@Param("id") Long id);
    
    @RequestLine("POST /api/products/{id}/tags?tagId={tagId}")
    Result<Void> addProductTag(@Param("id") Long id, @Param("tagId") Long tagId);
    
    @RequestLine("DELETE /api/products/{id}/tags/{tagId}")
    Result<Void> removeProductTag(@Param("id") Long id, @Param("tagId") Long tagId);
}

class CreateProductReq {
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private Integer stock;
    private Long categoryId;
    private String mainImage;
    private String images;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(BigDecimal originalPrice) { this.originalPrice = originalPrice; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getMainImage() { return mainImage; }
    public void setMainImage(String mainImage) { this.mainImage = mainImage; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}

class UpdateProductReq {
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private Integer stock;
    private Long categoryId;
    private String mainImage;
    private String images;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(BigDecimal originalPrice) { this.originalPrice = originalPrice; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getMainImage() { return mainImage; }
    public void setMainImage(String mainImage) { this.mainImage = mainImage; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}

class InventoryVO {
    private Long productId;
    private Integer quantity;
    private Integer lockedQuantity;
    private Integer availableQuantity;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getLockedQuantity() { return lockedQuantity; }
    public void setLockedQuantity(Integer lockedQuantity) { this.lockedQuantity = lockedQuantity; }
    public Integer getAvailableQuantity() { return availableQuantity; }
    public void setAvailableQuantity(Integer availableQuantity) { this.availableQuantity = availableQuantity; }
}

class ReviewVO {
    private Long id;
    private Long userId;
    private String username;
    private Integer rating;
    private String content;
    private String images;
    private Integer helpfulCount;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public Integer getHelpfulCount() { return helpfulCount; }
    public void setHelpfulCount(Integer helpfulCount) { this.helpfulCount = helpfulCount; }
}

class ProductStatisticsVO {
    private Long productId;
    private Integer viewCount;
    private Integer salesCount;
    private Integer reviewCount;
    private Double averageRating;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }
    public Integer getSalesCount() { return salesCount; }
    public void setSalesCount(Integer salesCount) { this.salesCount = salesCount; }
    public Integer getReviewCount() { return reviewCount; }
    public void setReviewCount(Integer reviewCount) { this.reviewCount = reviewCount; }
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
}

class ProductSpecVO {
    private Long id;
    private String name;
    private String value;
    private BigDecimal price;
    private Integer stock;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}

class CreateSpecReq {
    private String name;
    private String value;
    private BigDecimal price;
    private Integer stock;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}

class TagVO {
    private Long id;
    private String name;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
