<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26/12/24
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bai 1 - 2</title>
</head>
<body>
<form action="/account/login" method="post" enctype="multipart/form-data">
    <label for="username">Username:</label>
    <input name="username" id="username"/><br>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password"/><br>
    <label for="birth">Birth:</label>
    <input type="date" name="birth" id="birth"><br>
    <label for="file">File:</label>
    <input type="file" name="file" id="file"><br>
    <input type="checkbox" name="remember" id="remember"/><label for="remember">Remember me?</label><br>
    <button>Login</button>

    <ul>
        <li>
            <h3>User Information</h3>
            Username: ${username} <br>
            Password: ${password} <br>
            Birth: ${birth} <br>
            File path: ${filePath} <br>
            Remember: ${remember} <br>
            <br>
        </li>
        <li>
            SESSION:
            <ul>
                <c:forEach items="${sessionScope.values()}" var="sessionChild">
                    <c:if test="${sessionChild=='poly'}">
                        <li>
                                ${sessionChild}
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </li>
        <li>
            COOKIE:
            <ul>
                <c:forEach items="${cookie.values()}" var="cookieChild">
                    <c:if test="${cookieChild.name=='username'}">
                        <li>
                                ${cookieChild.name} - ${cookieChild.value}
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </li>
    </ul>
</form>
</body>
</html>
