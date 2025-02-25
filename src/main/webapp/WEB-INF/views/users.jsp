<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <title>用戶列表</title>
</head>
<body>
<h1>用戶列表</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>名稱</th>
        <th>Email</th>
        <th>連絡電話</th>
        <th>創建時間</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.tel}</td>
            <td>${user.create_time}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>