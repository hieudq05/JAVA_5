<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 31/12/24
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Filter product by PRICE - Bai 1</title>
</head>
<body>
<h1>Filter product by PRICE</h1>
<form method="POST" action="http://localhost:8080/product/price">
  <fieldset>
    <legend>Price Filter</legend>
    <input type="number" name="price_min" placeholder="Min price">
    ->
    <input type="number" name="price_max" placeholder="Max price">
    <button type="submit">Search</button>
  </fieldset>
</form>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Create Date</th>
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
