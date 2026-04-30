# Web Demo Projects

This repository contains comprehensive medium-scale API demo projects for testing API extraction tools.

## Project Structure

### English Version (en/)
- **java-springmvc**: Spring MVC REST API project with 250+ APIs
- **java-spring-webflux**: Spring WebFlux reactive API project with 250+ APIs
- **java-feign**: Feign client interfaces project
- **java-jaxrs**: JAX-RS API project
- **kotlin-springmvc**: Kotlin Spring MVC project

### Chinese Version (cn/)
- **java-springmvc**: Spring MVC REST API project with 250+ APIs
- **java-spring-webflux**: Spring WebFlux reactive API project with 250+ APIs
- **java-feign**: Feign client interfaces project
- **java-jaxrs**: JAX-RS API project
- **kotlin-springmvc**: Kotlin Spring MVC project

## API Modules

Each project includes the following modules with dozens of APIs:

### 1. User Management (UserController/UserClient)
- User CRUD operations (List, Create, Get, Update, Delete)
- Authentication (Login, Logout, Register)
- Password Management (Change, Reset)
- Profile Management (Get, Update, Upload Avatar)
- User Orders and Reviews
- Address Management
- Email/Phone Verification
- Favorites Management
- **Total: 30+ APIs**

### 2. Product Management (ProductController/ProductClient)
- Product CRUD operations
- Search and Filter
- Category-based queries
- Hot/New/Recommended products
- Image Management
- Stock Management
- Reviews and Statistics
- Product Specs and Tags
- Batch Operations
- Import/Export
- **Total: 35+ APIs**

### 3. Order Management (OrderController/OrderClient)
- Order CRUD operations
- Order Status Management
- Order Tracking
- Discount Management
- Order Items Management
- Payment and Shipping Info
- Refund Management
- Statistics and Reports
- Invoice Management
- Order Logs
- **Total: 40+ APIs**

### 4. Category Management (CategoryController/CategoryClient)
- Category CRUD operations
- Category Tree
- Move and Sort
- Category Products
- Path and Children
- Batch Operations
- **Total: 15+ APIs**

### 5. Inventory Management (InventoryController/InventoryClient)
- Inventory CRUD operations
- Stock In/Out operations
- Stock Check
- History Management
- Low Stock Alerts
- Batch Operations
- Warehouse Management
- Lock/Unlock Stock
- **Total: 20+ APIs**

### 6. Payment Management (PaymentController/PaymentClient)
- Payment CRUD operations
- Payment Verification
- Refund Processing
- Payment History
- Payment Methods
- Statistics
- Receipt Management
- **Total: 20+ APIs**

### 7. Shipping Management (ShippingController/ShippingClient)
- Shipping CRUD operations
- Shipping Tracking
- Cost Calculation
- Carrier Management
- Status Updates
- Timeline Management
- Delivery Confirmation
- **Total: 20+ APIs**

### 8. Review Management (ReviewController/ReviewClient)
- Review CRUD operations
- Like/Unlike
- Reply Management
- Statistics
- Rating Distribution
- Batch Operations
- Image Management
- **Total: 25+ APIs**

### 9. Notification Management (NotificationController/NotificationClient)
- Notification CRUD operations
- Mark as Read
- Unread Count
- Batch Operations
- Broadcast Notifications
- Settings Management
- Email/SMS Notifications
- **Total: 20+ APIs**

### 10. Analytics & Reporting (AnalyticsController/AnalyticsClient)
- Sales Reports (Daily, Monthly, By Category, By Product)
- User Statistics and Growth
- Product Statistics
- Revenue Reports
- Order Statistics
- Dashboard Overview
- Conversion Rates
- Traffic Sources
- Geographic Distribution
- Performance Metrics
- Real-time Statistics
- Export Functions
- **Total: 30+ APIs**

## Total API Count

Each project contains approximately **250+ APIs** across 10 modules, making it a true medium-scale project suitable for testing API extraction tools.

## Technology Stack

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

## Project Status

✅ **Completed:**
- java-springmvc (en/cn) - Full implementation with 250+ APIs
- java-spring-webflux (en/cn) - Reactive implementation with 250+ APIs
- java-feign (en/cn) - Client interfaces
- java-jaxrs (en/cn) - Controllers
- kotlin-springmvc (en/cn) - Kotlin controllers
- Model classes (User, Product, Order, Category, Inventory, Payment, Shipping, Review, Notification)
- DTO classes (Result, PageResult, PageRequest)
- All 10 controllers with comprehensive API implementations

## CI/CD

This project uses GitHub Actions for continuous integration. Each project is built independently using a matrix strategy, making it easy to identify which project failed in pull requests.

[![CI](https://github.com/Earth-1610/web-demo/actions/workflows/ci.yml/badge.svg)](https://github.com/Earth-1610/web-demo/actions/workflows/ci.yml)

## Usage

These projects are designed to test API extraction tools like:
- Easy API
- Postman
- Swagger/OpenAPI generators
- Custom API documentation tools

Each project follows standard conventions for its respective framework, making it easy to extract and document APIs.

## Build

Run the build script to compile all projects:

```bash
./script/package.sh
```

This will build all 10 projects (5 frameworks × 2 languages) and provide a summary of the build results.
