<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/12/24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bai 3</title>
</head>
<body>
<form action="/product/save" method="post">
  <input name="name">
  <input name="price">
  <button>Save</button>
</form>
<ul>
  <li>${product.name!=null?product.name:'?'}</li>
  <li>${product.price!=null?product.price:'?'}</li>
</ul>
</body>
</html>
