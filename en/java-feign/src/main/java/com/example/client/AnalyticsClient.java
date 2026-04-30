package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.dto.Result;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AnalyticsClient {
    
    @RequestLine("GET /api/analytics/dashboard")
    Result<DashboardVO> getDashboard();
    
    @RequestLine("GET /api/analytics/sales?startDate={startDate}&endDate={endDate}")
    Result<SalesAnalyticsVO> getSalesAnalytics(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/analytics/products/top-selling?limit={limit}&period={period}")
    Result<List<ProductSalesVO>> getTopSellingProducts(
            @Param("limit") Integer limit,
            @Param("period") String period);
    
    @RequestLine("GET /api/analytics/products/{productId}/performance")
    Result<ProductPerformanceVO> getProductPerformance(@Param("productId") Long productId);
    
    @RequestLine("GET /api/analytics/users/active?period={period}")
    Result<List<ActiveUserVO>> getActiveUsers(@Param("period") String period);
    
    @RequestLine("GET /api/analytics/users/{userId}/behavior")
    Result<UserBehaviorVO> getUserBehavior(@Param("userId") Long userId);
    
    @RequestLine("GET /api/analytics/revenue/daily?startDate={startDate}&endDate={endDate}")
    Result<List<DailyRevenueVO>> getDailyRevenue(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("GET /api/analytics/revenue/monthly?year={year}")
    Result<List<MonthlyRevenueVO>> getMonthlyRevenue(@Param("year") Integer year);
    
    @RequestLine("GET /api/analytics/categories/performance")
    Result<List<CategoryPerformanceVO>> getCategoryPerformance();
    
    @RequestLine("GET /api/analytics/orders/trends?period={period}")
    Result<List<OrderTrendVO>> getOrderTrends(@Param("period") String period);
    
    @RequestLine("GET /api/analytics/conversion/funnel")
    Result<ConversionFunnelVO> getConversionFunnel();
    
    @RequestLine("GET /api/analytics/traffic/sources")
    Result<List<TrafficSourceVO>> getTrafficSources();
    
    @RequestLine("GET /api/analytics/traffic/realtime")
    Result<RealtimeTrafficVO> getRealtimeTraffic();
    
    @RequestLine("GET /api/analytics/inventory/turnover")
    Result<List<InventoryTurnoverVO>> getInventoryTurnover();
    
    @RequestLine("GET /api/analytics/customers/segments")
    Result<List<CustomerSegmentVO>> getCustomerSegments();
    
    @RequestLine("GET /api/analytics/customers/lifetime-value")
    Result<List<CustomerLTVVO>> getCustomerLifetimeValue();
    
    @RequestLine("GET /api/analytics/reports/sales?startDate={startDate}&endDate={endDate}&format={format}")
    Result<String> generateSalesReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("format") String format);
    
    @RequestLine("GET /api/analytics/reports/inventory?format={format}")
    Result<String> generateInventoryReport(@Param("format") String format);
    
    @RequestLine("GET /api/analytics/reports/customers?format={format}")
    Result<String> generateCustomerReport(@Param("format") String format);
    
    @RequestLine("GET /api/analytics/kpis")
    Result<List<KPIVO>> getKPIs();
    
    @RequestLine("GET /api/analytics/forecast/sales?months={months}")
    Result<SalesForecastVO> getSalesForecast(@Param("months") Integer months);
    
    @RequestLine("GET /api/analytics/abandoned-carts")
    Result<AbandonedCartStatsVO> getAbandonedCartStats();
    
    @RequestLine("GET /api/analytics/payment-methods")
    Result<List<PaymentMethodStatsVO>> getPaymentMethodStats();
    
    @RequestLine("GET /api/analytics/geo-distribution")
    Result<List<GeoDistributionVO>> getGeoDistribution();
}

class DashboardVO {
    private Long totalOrders;
    private BigDecimal totalRevenue;
    private Long totalUsers;
    private Long totalProducts;
    private BigDecimal todayRevenue;
    private Long todayOrders;
    private Long newUsers;
    private BigDecimal conversionRate;
    
    public Long getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Long totalOrders) { this.totalOrders = totalOrders; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
    public Long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(Long totalUsers) { this.totalUsers = totalUsers; }
    public Long getTotalProducts() { return totalProducts; }
    public void setTotalProducts(Long totalProducts) { this.totalProducts = totalProducts; }
    public BigDecimal getTodayRevenue() { return todayRevenue; }
    public void setTodayRevenue(BigDecimal todayRevenue) { this.todayRevenue = todayRevenue; }
    public Long getTodayOrders() { return todayOrders; }
    public void setTodayOrders(Long todayOrders) { this.todayOrders = todayOrders; }
    public Long getNewUsers() { return newUsers; }
    public void setNewUsers(Long newUsers) { this.newUsers = newUsers; }
    public BigDecimal getConversionRate() { return conversionRate; }
    public void setConversionRate(BigDecimal conversionRate) { this.conversionRate = conversionRate; }
}

class SalesAnalyticsVO {
    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal averageOrderValue;
    private Long totalOrders;
    private BigDecimal growthRate;
    private List<DailySalesVO> dailySales;
    
    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
    public BigDecimal getAverageOrderValue() { return averageOrderValue; }
    public void setAverageOrderValue(BigDecimal averageOrderValue) { this.averageOrderValue = averageOrderValue; }
    public Long getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Long totalOrders) { this.totalOrders = totalOrders; }
    public BigDecimal getGrowthRate() { return growthRate; }
    public void setGrowthRate(BigDecimal growthRate) { this.growthRate = growthRate; }
    public List<DailySalesVO> getDailySales() { return dailySales; }
    public void setDailySales(List<DailySalesVO> dailySales) { this.dailySales = dailySales; }
}

class DailySalesVO {
    private String date;
    private BigDecimal revenue;
    private Long orders;
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    public Long getOrders() { return orders; }
    public void setOrders(Long orders) { this.orders = orders; }
}

class ProductSalesVO {
    private Long productId;
    private String productName;
    private Long salesCount;
    private BigDecimal revenue;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Long getSalesCount() { return salesCount; }
    public void setSalesCount(Long salesCount) { this.salesCount = salesCount; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
}

class ProductPerformanceVO {
    private Long productId;
    private String productName;
    private Long views;
    private Long purchases;
    private BigDecimal conversionRate;
    private BigDecimal revenue;
    private Double averageRating;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Long getViews() { return views; }
    public void setViews(Long views) { this.views = views; }
    public Long getPurchases() { return purchases; }
    public void setPurchases(Long purchases) { this.purchases = purchases; }
    public BigDecimal getConversionRate() { return conversionRate; }
    public void setConversionRate(BigDecimal conversionRate) { this.conversionRate = conversionRate; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
}

class ActiveUserVO {
    private Long userId;
    private String username;
    private Integer loginCount;
    private String lastLoginAt;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Integer getLoginCount() { return loginCount; }
    public void setLoginCount(Integer loginCount) { this.loginCount = loginCount; }
    public String getLastLoginAt() { return lastLoginAt; }
    public void setLastLoginAt(String lastLoginAt) { this.lastLoginAt = lastLoginAt; }
}

class UserBehaviorVO {
    private Long userId;
    private Integer totalOrders;
    private BigDecimal totalSpent;
    private Long totalViews;
    private Long totalWishlistItems;
    private Long totalReviews;
    private String preferredCategory;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Integer getTotalOrders() { return totalOrders; }
    public void setTotalOrders(Integer totalOrders) { this.totalOrders = totalOrders; }
    public BigDecimal getTotalSpent() { return totalSpent; }
    public void setTotalSpent(BigDecimal totalSpent) { this.totalSpent = totalSpent; }
    public Long getTotalViews() { return totalViews; }
    public void setTotalViews(Long totalViews) { this.totalViews = totalViews; }
    public Long getTotalWishlistItems() { return totalWishlistItems; }
    public void setTotalWishlistItems(Long totalWishlistItems) { this.totalWishlistItems = totalWishlistItems; }
    public Long getTotalReviews() { return totalReviews; }
    public void setTotalReviews(Long totalReviews) { this.totalReviews = totalReviews; }
    public String getPreferredCategory() { return preferredCategory; }
    public void setPreferredCategory(String preferredCategory) { this.preferredCategory = preferredCategory; }
}

class DailyRevenueVO {
    private String date;
    private BigDecimal revenue;
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
}

class MonthlyRevenueVO {
    private String month;
    private BigDecimal revenue;
    private BigDecimal growth;
    
    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    public BigDecimal getGrowth() { return growth; }
    public void setGrowth(BigDecimal growth) { this.growth = growth; }
}

class CategoryPerformanceVO {
    private Long categoryId;
    private String categoryName;
    private Long productCount;
    private Long salesCount;
    private BigDecimal revenue;
    
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public Long getProductCount() { return productCount; }
    public void setProductCount(Long productCount) { this.productCount = productCount; }
    public Long getSalesCount() { return salesCount; }
    public void setSalesCount(Long salesCount) { this.salesCount = salesCount; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
}

class OrderTrendVO {
    private String period;
    private Long orderCount;
    private BigDecimal revenue;
    
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    public Long getOrderCount() { return orderCount; }
    public void setOrderCount(Long orderCount) { this.orderCount = orderCount; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
}

class ConversionFunnelVO {
    private Long visitors;
    private Long productViews;
    private Long addToCart;
    private Long checkout;
    private Long purchases;
    private BigDecimal viewToCartRate;
    private BigDecimal cartToCheckoutRate;
    private BigDecimal checkoutToPurchaseRate;
    
    public Long getVisitors() { return visitors; }
    public void setVisitors(Long visitors) { this.visitors = visitors; }
    public Long getProductViews() { return productViews; }
    public void setProductViews(Long productViews) { this.productViews = productViews; }
    public Long getAddToCart() { return addToCart; }
    public void setAddToCart(Long addToCart) { this.addToCart = addToCart; }
    public Long getCheckout() { return checkout; }
    public void setCheckout(Long checkout) { this.checkout = checkout; }
    public Long getPurchases() { return purchases; }
    public void setPurchases(Long purchases) { this.purchases = purchases; }
    public BigDecimal getViewToCartRate() { return viewToCartRate; }
    public void setViewToCartRate(BigDecimal viewToCartRate) { this.viewToCartRate = viewToCartRate; }
    public BigDecimal getCartToCheckoutRate() { return cartToCheckoutRate; }
    public void setCartToCheckoutRate(BigDecimal cartToCheckoutRate) { this.cartToCheckoutRate = cartToCheckoutRate; }
    public BigDecimal getCheckoutToPurchaseRate() { return checkoutToPurchaseRate; }
    public void setCheckoutToPurchaseRate(BigDecimal checkoutToPurchaseRate) { this.checkoutToPurchaseRate = checkoutToPurchaseRate; }
}

class TrafficSourceVO {
    private String source;
    private Long visitors;
    private BigDecimal percentage;
    
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public Long getVisitors() { return visitors; }
    public void setVisitors(Long visitors) { this.visitors = visitors; }
    public BigDecimal getPercentage() { return percentage; }
    public void setPercentage(BigDecimal percentage) { this.percentage = percentage; }
}

class RealtimeTrafficVO {
    private Long activeUsers;
    private Long pageViews;
    private Long orders;
    private BigDecimal revenue;
    
    public Long getActiveUsers() { return activeUsers; }
    public void setActiveUsers(Long activeUsers) { this.activeUsers = activeUsers; }
    public Long getPageViews() { return pageViews; }
    public void setPageViews(Long pageViews) { this.pageViews = pageViews; }
    public Long getOrders() { return orders; }
    public void setOrders(Long orders) { this.orders = orders; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
}

class InventoryTurnoverVO {
    private Long productId;
    private String productName;
    private BigDecimal turnoverRate;
    private Integer daysInStock;
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public BigDecimal getTurnoverRate() { return turnoverRate; }
    public void setTurnoverRate(BigDecimal turnoverRate) { this.turnoverRate = turnoverRate; }
    public Integer getDaysInStock() { return daysInStock; }
    public void setDaysInStock(Integer daysInStock) { this.daysInStock = daysInStock; }
}

class CustomerSegmentVO {
    private String segment;
    private Long userCount;
    private BigDecimal averageOrderValue;
    private BigDecimal totalRevenue;
    
    public String getSegment() { return segment; }
    public void setSegment(String segment) { this.segment = segment; }
    public Long getUserCount() { return userCount; }
    public void setUserCount(Long userCount) { this.userCount = userCount; }
    public BigDecimal getAverageOrderValue() { return averageOrderValue; }
    public void setAverageOrderValue(BigDecimal averageOrderValue) { this.averageOrderValue = averageOrderValue; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
}

class CustomerLTVVO {
    private Long userId;
    private String username;
    private BigDecimal lifetimeValue;
    private Integer orderCount;
    private BigDecimal averageOrderValue;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public BigDecimal getLifetimeValue() { return lifetimeValue; }
    public void setLifetimeValue(BigDecimal lifetimeValue) { this.lifetimeValue = lifetimeValue; }
    public Integer getOrderCount() { return orderCount; }
    public void setOrderCount(Integer orderCount) { this.orderCount = orderCount; }
    public BigDecimal getAverageOrderValue() { return averageOrderValue; }
    public void setAverageOrderValue(BigDecimal averageOrderValue) { this.averageOrderValue = averageOrderValue; }
}

class KPIVO {
    private String name;
    private BigDecimal value;
    private BigDecimal target;
    private BigDecimal progress;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }
    public BigDecimal getTarget() { return target; }
    public void setTarget(BigDecimal target) { this.target = target; }
    public BigDecimal getProgress() { return progress; }
    public void setProgress(BigDecimal progress) { this.progress = progress; }
}

class SalesForecastVO {
    private List<ForecastDataVO> forecast;
    private BigDecimal confidence;
    
    public List<ForecastDataVO> getForecast() { return forecast; }
    public void setForecast(List<ForecastDataVO> forecast) { this.forecast = forecast; }
    public BigDecimal getConfidence() { return confidence; }
    public void setConfidence(BigDecimal confidence) { this.confidence = confidence; }
}

class ForecastDataVO {
    private String month;
    private BigDecimal predictedRevenue;
    private BigDecimal lowerBound;
    private BigDecimal upperBound;
    
    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public BigDecimal getPredictedRevenue() { return predictedRevenue; }
    public void setPredictedRevenue(BigDecimal predictedRevenue) { this.predictedRevenue = predictedRevenue; }
    public BigDecimal getLowerBound() { return lowerBound; }
    public void setLowerBound(BigDecimal lowerBound) { this.lowerBound = lowerBound; }
    public BigDecimal getUpperBound() { return upperBound; }
    public void setUpperBound(BigDecimal upperBound) { this.upperBound = upperBound; }
}

class AbandonedCartStatsVO {
    private Long totalCarts;
    private Long abandonedCarts;
    private BigDecimal abandonmentRate;
    private BigDecimal lostRevenue;
    
    public Long getTotalCarts() { return totalCarts; }
    public void setTotalCarts(Long totalCarts) { this.totalCarts = totalCarts; }
    public Long getAbandonedCarts() { return abandonedCarts; }
    public void setAbandonedCarts(Long abandonedCarts) { this.abandonedCarts = abandonedCarts; }
    public BigDecimal getAbandonmentRate() { return abandonmentRate; }
    public void setAbandonmentRate(BigDecimal abandonmentRate) { this.abandonmentRate = abandonmentRate; }
    public BigDecimal getLostRevenue() { return lostRevenue; }
    public void setLostRevenue(BigDecimal lostRevenue) { this.lostRevenue = lostRevenue; }
}

class PaymentMethodStatsVO {
    private String method;
    private Long transactionCount;
    private BigDecimal totalAmount;
    private BigDecimal percentage;
    
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public Long getTransactionCount() { return transactionCount; }
    public void setTransactionCount(Long transactionCount) { this.transactionCount = transactionCount; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public BigDecimal getPercentage() { return percentage; }
    public void setPercentage(BigDecimal percentage) { this.percentage = percentage; }
}

class GeoDistributionVO {
    private String region;
    private Long userCount;
    private BigDecimal revenue;
    private BigDecimal percentage;
    
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public Long getUserCount() { return userCount; }
    public void setUserCount(Long userCount) { this.userCount = userCount; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    public BigDecimal getPercentage() { return percentage; }
    public void setPercentage(BigDecimal percentage) { this.percentage = percentage; }
}
