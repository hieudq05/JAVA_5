<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/12/24
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Page - Bai 3</title>
</head>
<body>
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
  <c:forEach items="${products.content}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.createDate}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br>
<a href="http://localhost:8080/product/page?index=0">First</a>
<a href="http://localhost:8080/product/page?index=${products.number-1}">Prev</a>
<span>${products.number}</span>
<a href="http://localhost:8080/product/page?index=${products.number+1}">Next</a>
<a href="http://localhost:8080/product/page?index=${products.totalPages-1}">Last</a>
<hr>
<h4>Details Page:</h4>
<ul>
  <li>Số thực thể hiện tại: ${products.numberOfElements}</li>
  <li>Trang số: ${products.number}</li>
  <li>Kích thước trang: ${products.size}</li>
  <li>Tổng số thực thể: ${products.totalElements}</li>
  <li>Tổng số trang: ${products.totalPages-1}</li>
</ul>
</body>
</html>
