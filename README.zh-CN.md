# Web Demo Projects

[English](README.md) | [简体中文](README.zh-CN.md)

这是一个综合性的中等规模 API 示例项目，用于测试 API 提取工具。

[![CI](https://github.com/Earth-1610/web-demo/actions/workflows/ci.yml/badge.svg)](https://github.com/Earth-1610/web-demo/actions/workflows/ci.yml)

## 项目结构

### 英文版 (en/)
- **java-springmvc**: Spring MVC REST API 项目，包含 250+ 个 API
- **java-spring-webflux**: Spring WebFlux 响应式 API 项目，包含 250+ 个 API
- **java-feign**: Feign 客户端接口项目
- **java-jaxrs**: JAX-RS API 项目
- **kotlin-springmvc**: Kotlin Spring MVC 项目

### 中文版 (cn/)
- **java-springmvc**: Spring MVC REST API 项目，包含 250+ 个 API
- **java-spring-webflux**: Spring WebFlux 响应式 API 项目，包含 250+ 个 API
- **java-feign**: Feign 客户端接口项目
- **java-jaxrs**: JAX-RS API 项目
- **kotlin-springmvc**: Kotlin Spring MVC 项目

## API 模块

每个项目包含以下模块，每个模块包含数十个 API：

### 1. 用户管理 (UserController/UserClient)
- 用户增删改查操作（列表、创建、获取、更新、删除）
- 认证（登录、登出、注册）
- 密码管理（修改、重置）
- 个人资料管理（获取、更新、上传头像）
- 用户订单和评价
- 地址管理
- 邮箱/手机验证
- 收藏管理
- **总计：30+ 个 API**

### 2. 商品管理 (ProductController/ProductClient)
- 商品增删改查操作
- 搜索和筛选
- 基于分类的查询
- 热门/新品/推荐商品
- 图片管理
- 库存管理
- 评价和统计
- 商品规格和标签
- 批量操作
- 导入/导出
- **总计：35+ 个 API**

### 3. 订单管理 (OrderController/OrderClient)
- 订单增删改查操作
- 订单状态管理
- 订单跟踪
- 折扣管理
- 订单项管理
- 支付和配送信息
- 退款管理
- 统计和报表
- 发票管理
- 订单日志
- **总计：40+ 个 API**

### 4. 分类管理 (CategoryController/CategoryClient)
- 分类增删改查操作
- 分类树
- 移动和排序
- 分类商品
- 路径和子分类
- 批量操作
- **总计：15+ 个 API**

### 5. 库存管理 (InventoryController/InventoryClient)
- 库存增删改查操作
- 入库/出库操作
- 库存检查
- 历史记录管理
- 低库存预警
- 批量操作
- 仓库管理
- 锁定/解锁库存
- **总计：20+ 个 API**

### 6. 支付管理 (PaymentController/PaymentClient)
- 支付增删改查操作
- 支付验证
- 退款处理
- 支付历史
- 支付方式
- 统计
- 收据管理
- **总计：20+ 个 API**

### 7. 配送管理 (ShippingController/ShippingClient)
- 配送增删改查操作
- 配送跟踪
- 费用计算
- 承运商管理
- 状态更新
- 时间线管理
- 确认收货
- **总计：20+ 个 API**

### 8. 评价管理 (ReviewController/ReviewClient)
- 评价增删改查操作
- 点赞/取消点赞
- 回复管理
- 统计
- 评分分布
- 批量操作
- 图片管理
- **总计：25+ 个 API**

### 9. 通知管理 (NotificationController/NotificationClient)
- 通知增删改查操作
- 标记已读
- 未读数量
- 批量操作
- 广播通知
- 设置管理
- 邮件/短信通知
- **总计：20+ 个 API**

### 10. 分析与报表 (AnalyticsController/AnalyticsClient)
- 销售报表（日报、月报、按分类、按商品）
- 用户统计和增长
- 商品统计
- 收入报表
- 订单统计
- 仪表盘概览
- 转化率
- 流量来源
- 地理分布
- 性能指标
- 实时统计
- 导出功能
- **总计：30+ 个 API**

## API 总数

每个项目包含约 **250+ 个 API**，分布在 10 个模块中，是一个真正的中等规模项目，适合测试 API 提取工具。

## 技术栈

### java-springmvc
- Java 17
- Spring Boot 3.2.0
- Spring Web MVC
- Validation API

### java-spring-webflux
- Java 17
- Spring Boot 3.2.0
- Spring WebFlux
- Validation API

### java-feign
- Java 17
- OpenFeign 12.1
- Jackson

### java-jaxrs
- Java 17
- JAX-RS API
- Jersey

### kotlin-springmvc
- Kotlin
- Spring Boot 3.2.0
- Spring Web MVC

## 项目状态

✅ **已完成：**
- java-springmvc (en/cn) - 完整实现，包含 250+ 个 API
- java-spring-webflux (en/cn) - 响应式实现，包含 250+ 个 API
- java-feign (en/cn) - 客户端接口
- java-jaxrs (en/cn) - 控制器
- kotlin-springmvc (en/cn) - Kotlin 控制器
- Model 类（User、Product、Order、Category、Inventory、Payment、Shipping、Review、Notification）
- DTO 类（Result、PageResult、PageRequest）
- 所有 10 个控制器的完整 API 实现

## CI/CD

本项目使用 GitHub Actions 进行持续集成。每个项目使用矩阵策略独立构建，便于在 Pull Request 中识别哪个项目构建失败。

## 用途

这些项目旨在测试 API 提取工具，例如：
- Easy API
- Postman
- Swagger/OpenAPI 生成器
- 自定义 API 文档工具

每个项目遵循其各自框架的标准约定，便于提取和文档化 API。

## 构建

运行构建脚本来编译所有项目：

```bash
./script/package.sh
```

这将构建所有 10 个项目（5 个框架 × 2 种语言）并提供构建结果摘要。
