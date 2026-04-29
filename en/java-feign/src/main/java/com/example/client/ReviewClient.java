package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Review;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.util.List;

public interface ReviewClient {
    
    @RequestLine("GET /api/reviews?userId={userId}&productId={productId}&rating={rating}&status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Review>> listReviews(
            @Param("userId") Long userId,
            @Param("productId") Long productId,
            @Param("rating") Integer rating,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/reviews")
    Result<Review> createReview(CreateReviewReq req);
    
    @RequestLine("GET /api/reviews/{id}")
    Result<Review> getReview(@Param("id") Long id);
    
    @RequestLine("PUT /api/reviews/{id}")
    Result<Review> updateReview(@Param("id") Long id, UpdateReviewReq req);
    
    @RequestLine("DELETE /api/reviews/{id}")
    Result<Void> deleteReview(@Param("id") Long id);
    
    @RequestLine("POST /api/reviews/{id}/like")
    Result<Review> likeReview(@Param("id") Long id);
    
    @RequestLine("DELETE /api/reviews/{id}/like")
    Result<Review> unlikeReview(@Param("id") Long id);
    
    @RequestLine("POST /api/reviews/{id}/reply")
    Result<ReviewReplyVO> replyToReview(@Param("id") Long id, CreateReplyReq req);
    
    @RequestLine("GET /api/reviews/{id}/replies")
    Result<List<ReviewReplyVO>> getReplies(@Param("id") Long id);
    
    @RequestLine("GET /api/reviews/product/{productId}?rating={rating}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Review>> getProductReviews(
            @Param("productId") Long productId,
            @Param("rating") Integer rating,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/reviews/user/{userId}?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Review>> getUserReviews(
            @Param("userId") Long userId,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("PUT /api/reviews/{id}/status?status={status}")
    Result<Review> updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    @RequestLine("GET /api/reviews/product/{productId}/statistics")
    Result<ReviewStatisticsVO> getProductStatistics(@Param("productId") Long productId);
    
    @RequestLine("GET /api/reviews/product/{productId}/rating-distribution")
    Result<List<RatingDistributionVO>> getRatingDistribution(@Param("productId") Long productId);
    
    @RequestLine("GET /api/reviews/recent?limit={limit}")
    Result<List<Review>> getRecentReviews(@Param("limit") Integer limit);
    
    @RequestLine("GET /api/reviews/helpful?limit={limit}")
    Result<List<Review>> getHelpfulReviews(@Param("limit") Integer limit);
    
    @RequestLine("POST /api/reviews/batch-approve")
    Result<Void> batchApprove(List<Long> ids);
    
    @RequestLine("POST /api/reviews/batch-reject?reason={reason}")
    Result<Void> batchReject(List<Long> ids, @Param("reason") String reason);
    
    @RequestLine("GET /api/reviews/pending?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Review>> getPendingReviews(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/reviews/export?productId={productId}&startDate={startDate}&endDate={endDate}")
    Result<String> exportReviews(
            @Param("productId") Long productId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/reviews/{id}/images")
    Result<List<String>> getReviewImages(@Param("id") Long id);
    
    @RequestLine("DELETE /api/reviews/{id}/images?imageUrl={imageUrl}")
    Result<Void> deleteReviewImage(@Param("id") Long id, @Param("imageUrl") String imageUrl);
}

class CreateReviewReq {
    private Long userId;
    private Long productId;
    private Long orderId;
    private Integer rating;
    private String content;
    private String images;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}

class UpdateReviewReq {
    private Integer rating;
    private String content;
    private String images;
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}

class CreateReplyReq {
    private Long userId;
    private String content;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}

class ReviewReplyVO {
    private Long id;
    private Long reviewId;
    private Long userId;
    private String username;
    private String content;
    private String createdAt;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}

class ReviewStatisticsVO {
    private Long productId;
    private Long totalReviews;
    private Double averageRating;
    private Integer fiveStarCount;
    private Integer fourStarCount;
    private Integer threeStarCount;
    private Integer twoStarCount;
    private Integer oneStarCount;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Long getTotalReviews() { return totalReviews; }
    public void setTotalReviews(Long totalReviews) { this.totalReviews = totalReviews; }
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
    public Integer getFiveStarCount() { return fiveStarCount; }
    public void setFiveStarCount(Integer fiveStarCount) { this.fiveStarCount = fiveStarCount; }
    public Integer getFourStarCount() { return fourStarCount; }
    public void setFourStarCount(Integer fourStarCount) { this.fourStarCount = fourStarCount; }
    public Integer getThreeStarCount() { return threeStarCount; }
    public void setThreeStarCount(Integer threeStarCount) { this.threeStarCount = threeStarCount; }
    public Integer getTwoStarCount() { return twoStarCount; }
    public void setTwoStarCount(Integer twoStarCount) { this.twoStarCount = twoStarCount; }
    public Integer getOneStarCount() { return oneStarCount; }
    public void setOneStarCount(Integer oneStarCount) { this.oneStarCount = oneStarCount; }
}

class RatingDistributionVO {
    private Integer rating;
    private Integer count;
    private Double percentage;
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }
    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }
}
