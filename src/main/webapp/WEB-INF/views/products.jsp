<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<h2>商品列表</h2>
<table border="1">
    <tr>
        <th>名稱</th>
        <th>價格</th>
        <th>庫存</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
