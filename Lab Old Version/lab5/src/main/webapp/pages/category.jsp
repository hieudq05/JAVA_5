<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28/12/24
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category App - Bai 1</title>
</head>
<body>
<h1>CATEGORY MANAGEMENT</h1>
<form method="POST">
  <input type="text" id="id" name="id" placeholder="Category ID" value="${category.id}" required>
  <input type="text" id="name" name="name" placeholder="Category name" value="${category.name}" required>
  <br> <br>
  <input type="submit" value="Create" formaction="http://localhost:8080/category/add">
  <input type="submit" value="Update" formaction="http://localhost:8080/category/update">
  <input type="submit" value="Delete" formaction="http://localhost:8080/category/delete">
  <input value="Reset" type="button" id="reset">
</form>
<div style="color: red">${message}</div>
<table border="1">
  <thead>
    <tr>
      <th>Category ID</th>
      <th>Category name</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${categories}" var="category">
      <tr>
        <td>${category.id}</td>
        <td>${category.name}</td>
        <td><button onclick="location.href='http://localhost:8080/category?id=${category.id}'">Edit</button></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
<script>
  const reset = document.getElementById('reset');
  reset.addEventListener('click', function() {
    location.href = 'http://localhost:8080/category';
  });
</script>
</html>
