package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Shipping;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.math.BigDecimal;
import java.util.List;

public interface ShippingClient {
    
    @RequestLine("GET /api/shipping?orderId={orderId}&trackingNo={trackingNo}&status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Shipping>> listShipping(
            @Param("orderId") Long orderId,
            @Param("trackingNo") String trackingNo,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/shipping")
    Result<Shipping> createShipping(CreateShippingReq req);
    
    @RequestLine("GET /api/shipping/{id}")
    Result<Shipping> getShipping(@Param("id") Long id);
    
    @RequestLine("PUT /api/shipping/{id}")
    Result<Shipping> updateShipping(@Param("id") Long id, UpdateShippingReq req);
    
    @RequestLine("GET /api/shipping/no/{shippingNo}")
    Result<Shipping> getShippingByNo(@Param("shippingNo") String shippingNo);
    
    @RequestLine("GET /api/shipping/{id}/track")
    Result<ShippingTrackVO> trackShipping(@Param("id") Long id);
    
    @RequestLine("POST /api/shipping/{id}/cancel")
    Result<Shipping> cancelShipping(@Param("id") Long id);
    
    @RequestLine("GET /api/shipping/order/{orderId}")
    Result<Shipping> getShippingByOrder(@Param("orderId") Long orderId);
    
    @RequestLine("POST /api/shipping/calculate-cost")
    Result<ShippingCostVO> calculateCost(CalculateShippingCostReq req);
    
    @RequestLine("GET /api/shipping/carriers")
    Result<List<CarrierVO>> getCarriers();
    
    @RequestLine("PUT /api/shipping/{id}/status?status={status}")
    Result<Shipping> updateStatus(@Param("id") Long id, @Param("status") Integer status);
    
    @RequestLine("PUT /api/shipping/{id}/tracking?trackingNo={trackingNo}&carrier={carrier}")
    Result<Shipping> updateTracking(
            @Param("id") Long id,
            @Param("trackingNo") String trackingNo,
            @Param("carrier") String carrier);
    
    @RequestLine("GET /api/shipping/{id}/timeline")
    Result<List<ShippingTimelineVO>> getTimeline(@Param("id") Long id);
    
    @RequestLine("GET /api/shipping/pending?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Shipping>> getPendingShipping(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/shipping/in-transit?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Shipping>> getInTransitShipping(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/shipping/delivered?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Shipping>> getDeliveredShipping(
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/shipping/statistics")
    Result<ShippingStatisticsVO> getStatistics();
    
    @RequestLine("GET /api/shipping/export?startDate={startDate}&endDate={endDate}")
    Result<String> exportShipping(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
    
    @RequestLine("POST /api/shipping/{id}/confirm-delivery")
    Result<Shipping> confirmDelivery(@Param("id") Long id);
    
    @RequestLine("POST /api/shipping/{id}/reschedule?newDate={newDate}")
    Result<Shipping> rescheduleDelivery(@Param("id") Long id, @Param("newDate") String newDate);
}

class CreateShippingReq {
    private Long orderId;
    private String carrier;
    private String receiverName;
    private String receiverPhone;
    private String shippingAddress;
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}

class UpdateShippingReq {
    private String carrier;
    private String receiverName;
    private String receiverPhone;
    private String shippingAddress;
    
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }
    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
}

class ShippingTrackVO {
    private String shippingNo;
    private String carrier;
    private String trackingNo;
    private Integer status;
    private String currentLocation;
    private List<TrackEventVO> events;
    
    public String getShippingNo() { return shippingNo; }
    public void setShippingNo(String shippingNo) { this.shippingNo = shippingNo; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public String getTrackingNo() { return trackingNo; }
    public void setTrackingNo(String trackingNo) { this.trackingNo = trackingNo; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public List<TrackEventVO> getEvents() { return events; }
    public void setEvents(List<TrackEventVO> events) { this.events = events; }
}

class TrackEventVO {
    private String time;
    private String location;
    private String description;
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

class CalculateShippingCostReq {
    private String fromAddress;
    private String toAddress;
    private BigDecimal weight;
    private String carrier;
    
    public String getFromAddress() { return fromAddress; }
    public void setFromAddress(String fromAddress) { this.fromAddress = fromAddress; }
    public String getToAddress() { return toAddress; }
    public void setToAddress(String toAddress) { this.toAddress = toAddress; }
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
}

class ShippingCostVO {
    private BigDecimal baseCost;
    private BigDecimal weightCost;
    private BigDecimal totalCost;
    private Integer estimatedDays;
    
    public BigDecimal getBaseCost() { return baseCost; }
    public void setBaseCost(BigDecimal baseCost) { this.baseCost = baseCost; }
    public BigDecimal getWeightCost() { return weightCost; }
    public void setWeightCost(BigDecimal weightCost) { this.weightCost = weightCost; }
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    public Integer getEstimatedDays() { return estimatedDays; }
    public void setEstimatedDays(Integer estimatedDays) { this.estimatedDays = estimatedDays; }
}

class CarrierVO {
    private String code;
    private String name;
    private String logo;
    private Boolean enabled;
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
}

class ShippingTimelineVO {
    private String time;
    private String status;
    private String description;
    private String location;
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}

class ShippingStatisticsVO {
    private Long totalShipping;
    private Long pendingShipping;
    private Long inTransitShipping;
    private Long deliveredShipping;
    private Long cancelledShipping;
    
    public Long getTotalShipping() { return totalShipping; }
    public void setTotalShipping(Long totalShipping) { this.totalShipping = totalShipping; }
    public Long getPendingShipping() { return pendingShipping; }
    public void setPendingShipping(Long pendingShipping) { this.pendingShipping = pendingShipping; }
    public Long getInTransitShipping() { return inTransitShipping; }
    public void setInTransitShipping(Long inTransitShipping) { this.inTransitShipping = inTransitShipping; }
    public Long getDeliveredShipping() { return deliveredShipping; }
    public void setDeliveredShipping(Long deliveredShipping) { this.deliveredShipping = deliveredShipping; }
    public Long getCancelledShipping() { return cancelledShipping; }
    public void setCancelledShipping(Long cancelledShipping) { this.cancelledShipping = cancelledShipping; }
}
