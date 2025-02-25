<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>訂單列表</title>
</head>
<body>
<h2>訂單列表</h2>

<table border="1">
    <tr>
        <th>訂單 ID</th>
        <th>客戶名稱</th>
        <th>商品名稱</th>
        <th>數量</th>
        <th>總金額</th>
        <th>訂單時間</th>
    </tr>

    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.user.username}</td>
            <td>${order.product.name}</td>
            <td>${order.quantity}</td>
            <td>${order.totalPrice}</td>
            <td>${order.orderTime}</td>
        </tr>
    </c:forEach>
</table>

<!-- 分頁按鈕 -->
<div>
    <c:if test="${currentPage > 1}">
        <a href="?page=${currentPage - 1}&pageSize=${pageSize}">上一頁</a>
    </c:if>

    <c:if test="${orders.size() == pageSize}">
        <a href="?page=${currentPage + 1}&pageSize=${pageSize}">下一頁</a>
    </c:if>
</div>
</body>
</html>