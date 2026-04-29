package com.example.client;

import feign.Param;
import feign.RequestLine;
import com.example.model.User;
import com.example.dto.Result;
import com.example.dto.PageResult;
import java.util.List;

public interface UserClient {
    
    @RequestLine("GET /api/users?keyword={keyword}&status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<User>> listUsers(
            @Param("keyword") String keyword,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/users")
    Result<User> createUser(CreateUserReq req);
    
    @RequestLine("GET /api/users/{id}")
    Result<User> getUser(@Param("id") Long id);
    
    @RequestLine("PUT /api/users/{id}")
    Result<User> updateUser(@Param("id") Long id, UpdateUserReq req);
    
    @RequestLine("DELETE /api/users/{id}")
    Result<Void> deleteUser(@Param("id") Long id);
    
    @RequestLine("POST /api/users/login")
    Result<LoginResp> login(LoginReq req);
    
    @RequestLine("POST /api/users/logout")
    Result<Void> logout();
    
    @RequestLine("POST /api/users/register")
    Result<User> register(RegisterReq req);
    
    @RequestLine("POST /api/users/{id}/change-password")
    Result<Void> changePassword(@Param("id") Long id, ChangePasswordReq req);
    
    @RequestLine("POST /api/users/reset-password")
    Result<Void> resetPassword(ResetPasswordReq req);
    
    @RequestLine("GET /api/users/{id}/profile")
    Result<User> getProfile(@Param("id") Long id);
    
    @RequestLine("PUT /api/users/{id}/profile")
    Result<User> updateProfile(@Param("id") Long id, UpdateProfileReq req);
    
    @RequestLine("GET /api/users/{id}/orders?status={status}&pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Object>> getUserOrders(
            @Param("id") Long id,
            @Param("status") Integer status,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/users/{id}/reviews?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Object>> getUserReviews(
            @Param("id") Long id,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("GET /api/users/{id}/addresses")
    Result<List<AddressVO>> getUserAddresses(@Param("id") Long id);
    
    @RequestLine("POST /api/users/{id}/addresses")
    Result<AddressVO> createAddress(@Param("id") Long id, CreateAddressReq req);
    
    @RequestLine("PUT /api/users/{id}/addresses/{addressId}")
    Result<AddressVO> updateAddress(@Param("id") Long id, @Param("addressId") Long addressId, UpdateAddressReq req);
    
    @RequestLine("DELETE /api/users/{id}/addresses/{addressId}")
    Result<Void> deleteAddress(@Param("id") Long id, @Param("addressId") Long addressId);
    
    @RequestLine("PUT /api/users/{id}/addresses/{addressId}/default")
    Result<Void> setDefaultAddress(@Param("id") Long id, @Param("addressId") Long addressId);
    
    @RequestLine("GET /api/users/check-username?username={username}")
    Result<Boolean> checkUsername(@Param("username") String username);
    
    @RequestLine("GET /api/users/check-email?email={email}")
    Result<Boolean> checkEmail(@Param("email") String email);
    
    @RequestLine("GET /api/users/check-phone?phone={phone}")
    Result<Boolean> checkPhone(@Param("phone") String phone);
    
    @RequestLine("POST /api/users/{id}/verify-email?code={code}")
    Result<Void> verifyEmail(@Param("id") Long id, @Param("code") String code);
    
    @RequestLine("POST /api/users/{id}/verify-phone?code={code}")
    Result<Void> verifyPhone(@Param("id") Long id, @Param("code") String code);
    
    @RequestLine("POST /api/users/{id}/send-verification-email")
    Result<Void> sendVerificationEmail(@Param("id") Long id);
    
    @RequestLine("POST /api/users/{id}/send-verification-sms")
    Result<Void> sendVerificationSms(@Param("id") Long id);
    
    @RequestLine("GET /api/users/{id}/favorites?pageNum={pageNum}&pageSize={pageSize}")
    Result<PageResult<Object>> getUserFavorites(
            @Param("id") Long id,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);
    
    @RequestLine("POST /api/users/{id}/favorites?productId={productId}")
    Result<Void> addFavorite(@Param("id") Long id, @Param("productId") Long productId);
    
    @RequestLine("DELETE /api/users/{id}/favorites/{productId}")
    Result<Void> removeFavorite(@Param("id") Long id, @Param("productId") Long productId);
}

class CreateUserReq {
    private String username;
    private String email;
    private String password;
    private String phone;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class UpdateUserReq {
    private String username;
    private String email;
    private String phone;
    private Integer status;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}

class LoginReq {
    private String username;
    private String password;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class LoginResp {
    private String token;
    private User user;
    
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

class RegisterReq {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String verificationCode;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
}

class ChangePasswordReq {
    private String oldPassword;
    private String newPassword;
    
    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }
    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}

class ResetPasswordReq {
    private String email;
    private String verificationCode;
    private String newPassword;
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}

class UpdateProfileReq {
    private String username;
    private String phone;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

class AddressVO {
    private Long id;
    private String receiverName;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String detail;
    private Integer isDefault;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
    public Integer getIsDefault() { return isDefault; }
    public void setIsDefault(Integer isDefault) { this.isDefault = isDefault; }
}

class CreateAddressReq {
    private String receiverName;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String detail;
    
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}

class UpdateAddressReq {
    private String receiverName;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String detail;
    
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}
