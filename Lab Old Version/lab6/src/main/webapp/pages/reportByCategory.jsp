<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/1/25
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Report By Category - Bai 3</title>
</head>
<body>
<h1>TỒN KHO THEO LOẠI</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Total Price</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reports}" var="report">
        <tr>
            <td>${report.categoryName}</td>
            <td>${report.totalPrice}</td>
            <td>${report.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
