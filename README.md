# Product & Order Management API

本專案是一個基於 **Spring Boot** 的 RESTful API，提供商品與訂單的 CRUD 功能，並整合 **JPA** 及 **MyBatis** 以最佳化數據查詢與操作。前端部分提供 **JSP** 頁面渲染，並可透過 **Docker** 部署至容器化環境。

## 技術架構

- **Spring Boot** - 後端框架
- **JPA (Hibernate)** - 基本數據操作
- **MyBatis** - 用於處理複雜查詢與 SQL 優化
- **Spring MVC** - 提供 JSP 頁面控制器
- **Docker** - 容器化部署

## API 端點

### 產品管理（Product）

| 方法 | 端點 | 描述 | 使用技術 |
|------|-------------------------|----------------|------------|
| GET | `/api/products?page=1&size=10` | 分頁查詢商品列表 | MyBatis |
| GET | `/api/products/{id}` | 根據 ID 查詢商品 | JPA |
| POST | `/api/products` | 新增商品 | JPA |
| PUT | `/api/products/{id}` | 更新商品 | JPA |
| DELETE | `/api/products/{id}` | 刪除商品 | JPA |

### 訂單管理（Order）

| 方法 | 端點 | 描述 | 使用技術 |
|------|-------------------------|----------------|------------|
| POST | `/api/orders` | 新增訂單 | JPA |
| PUT | `/api/orders/{id}` | 更新訂單 | JPA |
| POST | `/api/orders/pricing/calculate` | 查詢訂單價格使用何種優惠 | JPA |
