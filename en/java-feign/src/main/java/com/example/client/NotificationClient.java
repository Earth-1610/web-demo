package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.Notification;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.util.List;

public interface NotificationClient {
    
    @RequestLine("GET /api/notifications?userId={userId}&type={type}&isRead={isRead}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Notification>> listNotifications(
            @Param("userId") Long userId,
            @Param("type") String type,
            @Param("isRead") Integer isRead,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/notifications")
    Result<Notification> createNotification(CreateNotificationReq req);
    
    @RequestLine("GET /api/notifications/{id}")
    Result<Notification> getNotification(@Param("id") Long id);
    
    @RequestLine("DELETE /api/notifications/{id}")
    Result<Void> deleteNotification(@Param("id") Long id);
    
    @RequestLine("PUT /api/notifications/{id}/read")
    Result<Notification> markAsRead(@Param("id") Long id);
    
    @RequestLine("PUT /api/notifications/user/{userId}/read-all")
    Result<Void> markAllAsRead(@Param("userId") Long userId);
    
    @RequestLine("GET /api/notifications/user/{userId}/unread-count")
    Result<Long> getUnreadCount(@Param("userId") Long userId);
    
    @RequestLine("DELETE /api/notifications/user/{userId}/read")
    Result<Void> deleteReadNotifications(@Param("userId") Long userId);
    
    @RequestLine("DELETE /api/notifications/user/{userId}/all")
    Result<Void> deleteAllNotifications(@Param("userId") Long userId);
    
    @RequestLine("GET /api/notifications/user/{userId}/recent?limit={limit}")
    Result<List<Notification>> getRecentNotifications(
            @Param("userId") Long userId,
            @Param("limit") Integer limit);
    
    @RequestLine("GET /api/notifications/types")
    Result<List<NotificationTypeVO>> getNotificationTypes();
    
    @RequestLine("POST /api/notifications/batch")
    Result<List<Notification>> batchCreate(List<CreateNotificationReq> reqs);
    
    @RequestLine("POST /api/notifications/broadcast")
    Result<Void> broadcastNotification(BroadcastNotificationReq req);
    
    @RequestLine("GET /api/notifications/user/{userId}/by-type?type={type}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Notification>> getByType(
            @Param("userId") Long userId,
            @Param("type") String type,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("PUT /api/notifications/batch-read")
    Result<Void> batchMarkAsRead(List<Long> ids);
    
    @RequestLine("DELETE /api/notifications/batch")
    Result<Void> batchDelete(List<Long> ids);
    
    @RequestLine("GET /api/notifications/user/{userId}/settings")
    Result<NotificationSettingsVO> getSettings(@Param("userId") Long userId);
    
    @RequestLine("PUT /api/notifications/user/{userId}/settings")
    Result<NotificationSettingsVO> updateSettings(
            @Param("userId") Long userId,
            UpdateNotificationSettingsReq req);
    
    @RequestLine("POST /api/notifications/send-email")
    Result<Void> sendEmailNotification(EmailNotificationReq req);
    
    @RequestLine("POST /api/notifications/send-sms")
    Result<Void> sendSmsNotification(SmsNotificationReq req);
}

class CreateNotificationReq {
    private Long userId;
    private String title;
    private String content;
    private String type;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

class NotificationTypeVO {
    private String code;
    private String name;
    private String description;
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

class BroadcastNotificationReq {
    private String title;
    private String content;
    private String type;
    private List<Long> userIds;
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<Long> getUserIds() { return userIds; }
    public void setUserIds(List<Long> userIds) { this.userIds = userIds; }
}

class NotificationSettingsVO {
    private Long userId;
    private Boolean emailEnabled;
    private Boolean smsEnabled;
    private Boolean pushEnabled;
    private List<String> enabledTypes;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Boolean getEmailEnabled() { return emailEnabled; }
    public void setEmailEnabled(Boolean emailEnabled) { this.emailEnabled = emailEnabled; }
    public Boolean getSmsEnabled() { return smsEnabled; }
    public void setSmsEnabled(Boolean smsEnabled) { this.smsEnabled = smsEnabled; }
    public Boolean getPushEnabled() { return pushEnabled; }
    public void setPushEnabled(Boolean pushEnabled) { this.pushEnabled = pushEnabled; }
    public List<String> getEnabledTypes() { return enabledTypes; }
    public void setEnabledTypes(List<String> enabledTypes) { this.enabledTypes = enabledTypes; }
}

class UpdateNotificationSettingsReq {
    private Boolean emailEnabled;
    private Boolean smsEnabled;
    private Boolean pushEnabled;
    private List<String> enabledTypes;
    
    public Boolean getEmailEnabled() { return emailEnabled; }
    public void setEmailEnabled(Boolean emailEnabled) { this.emailEnabled = emailEnabled; }
    public Boolean getSmsEnabled() { return smsEnabled; }
    public void setSmsEnabled(Boolean smsEnabled) { this.smsEnabled = smsEnabled; }
    public Boolean getPushEnabled() { return pushEnabled; }
    public void setPushEnabled(Boolean pushEnabled) { this.pushEnabled = pushEnabled; }
    public List<String> getEnabledTypes() { return enabledTypes; }
    public void setEnabledTypes(List<String> enabledTypes) { this.enabledTypes = enabledTypes; }
}

class EmailNotificationReq {
    private Long userId;
    private String email;
    private String subject;
    private String content;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}

class SmsNotificationReq {
    private Long userId;
    private String phone;
    private String content;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
