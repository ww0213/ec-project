專案內容:
RESTful API （Product,order）管理 的 CRUD 功能。
後端架構：使用 Spring Boot + JPA + MyBatis，整合不同 ORM 技術，JPA 處理一般數據操作，MyBatis 負責 複雜查詢與 SQL 優化。
前端渲染：提供 JSP 頁面控制器（Controller），支援傳統 Web 頁面開發。
Docker 部署：編寫 Dockerfile，可將專案容器化並在 Docker 環境執行。

API:
GET /api/products?page=1&size=10 - （MyBatis）分頁查詢商品列表
GET /api/products/{id} - （JPA）根據 ID 查詢商品
POST /api/products - （JPA）新增商品
PUT /api/products/{id} - （JPA）更新商品
DELETE /api/products/{id} - （JPA）刪除商品

POST /api/orders - （JPA）新增訂單
PUT /api/orders/{id} - （JPA）更新訂單

POST /api/orders/pricing/calculate - 查詢價格 
