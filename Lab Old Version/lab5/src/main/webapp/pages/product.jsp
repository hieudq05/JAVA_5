<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/12/24
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product App - Bai 2</title>
</head>
<body>
<h1>${sortBy==null?"LIST PRODUCT NO SORT":sortBy}</h1>
<br>
<c:if test="${sortBy!=null}">
    <button onclick="location.href='http://localhost:8080/product'">Clear filter</button>
</c:if>
<br><br>
<table border="1">
    <thead>
    <tr>
        <th><a href="http://localhost:8080/product/sort/id">ID</a></th>
        <th><a href="http://localhost:8080/product/sort/name">Name</a></th>
        <th><a href="http://localhost:8080/product/sort/price">Price</a></th>
        <th><a href="http://localhost:8080/product/sort/createDate">Create Date</a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.createDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
