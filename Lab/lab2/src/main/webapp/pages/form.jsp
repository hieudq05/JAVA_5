<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/12/24
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bai 2</title>
</head>
<body>
<form action="/param/save/2021" method="post">
    <input name="y" value="2031">
    <button>Save</button>
</form>
<ul>
    <li>Path variable: ${x}</li>
    <li>Request param: ${y}</li>
</ul>
</body>
</html>
