<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/12/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Bai 4</title>
</head>
<body>
<form action="/products/save" method="post">
  <input name="name">
  <input name="price">
  <button>Save</button>
</form>
<ul>
    <c:forEach items="${products}" var="product">
        <li>${product.name} - ${product.price}</li>
    </c:forEach>
</ul>
</body>
</html>
