<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21/12/24
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/ctrl/ok" method="post">
    <button>OK 1</button>
    <button formmethod="get">OK 2</button>
    <button formaction="/ctrl/ok?x">OK 3</button>
</form>
Kết quả: ${method}
</body>
</html>
