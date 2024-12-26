<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26/12/24
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bai 3</title>
</head>
<body>
    <h3>Products 📦</h3>
    <ul style="list-style: -moz-ethiopic-numeric">
        <form action="add" method="post">
            <c:forEach items="${items}" var="item">
                <li><button name="id" value="${item.id}">Add cart</button> ${item.name} ---- ${item.price}</li>
            </c:forEach>
        </form>
    </ul>
    <br>
    <h3>Cart 🛒</h3>
    <div>Total: <strong>${total}</strong></div>
    <div>Count: <strong>${count}</strong></div>
    <br>
    <form method="post">
        <table border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cartItems}" var="item">
                <tr>
                    <th>${item.value.id}</th>
                    <th>${item.value.name}</th>
                    <th>${item.value.price}</th>
                    <th>
                        <button formaction="update/${item.value.id}" name="method" value="minus">-</button>
                         ${item.value.qty}
                        <button formaction="update/${item.value.id}" name="method" value="plus">+</button></th>
                    <th>${item.value.qty * item.value.price}</th>
                    <th><button formaction="remove" name="id" value="${item.value.id}">Remove</button></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <button formaction="clear">Clear</button>
    </form>
</body>
</html>
