<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 31/12/24
  Time: 01:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Filter Product By Name - Bai 2</title>
</head>
<body>
<h1>Filter product by PRICE</h1>
<form method="GET" action="http://localhost:8080/product/filtername">
    <fieldset>
        <legend>Name Filter</legend>
        <input type="text" name="name" placeholder="Name" value="${name}">
        <button type="submit">Find</button>
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
<c:if test="${name==''}">
    <a href="http://localhost:8080/product/filtername?page=0">First</a>
    <a href="http://localhost:8080/product/filtername?page=${products.number-1}">Prev</a>
    <span>${products.number}</span>
    <a href="http://localhost:8080/product/filtername?page=${products.number+1}">Next</a>
    <a href="http://localhost:8080/product/filtername?page=${products.totalPages-1}">Last</a>
</c:if>
<c:if test="${name!=''}">
    <a href="http://localhost:8080/product/filtername?page=0&name=${name}">First</a>
    <a href="http://localhost:8080/product/filtername?page=${products.number-1}&name=${name}">Prev</a>
    <span>${products.number}</span>
    <a href="http://localhost:8080/product/filtername?page=${products.number+1}&name=${name}">Next</a>
    <a href="http://localhost:8080/product/filtername?page=${products.totalPages-1}&name=${name}">Last</a>
</c:if>
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
