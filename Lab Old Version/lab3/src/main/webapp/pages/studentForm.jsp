<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/12/24
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bai 1</title>
</head>
<body>
<form:form action="/student/form" modelAttribute="student" method="post">
    <form:label path="">Name</form:label> <br>
    <form:input path="name"/> <br>
    <form:errors path="name" cssStyle="color: red"/> <br>


    <form:label path="">Email</form:label> <br>
    <form:input path="email"/> <br>
    <form:errors path="email" cssStyle="color: red"/> <br>

    <form:label path="">Marks</form:label> <br>
    <form:input path="marks"/> <br>
    <form:errors path="marks" cssStyle="color: red"/> <br>

    <form:label path="">Gender</form:label> <br>
    <form:radiobuttons path="gender" items="${gender}"/> <br>
    <form:errors path="gender" cssStyle="color: red"/> <br>

    <form:label path="">Hobby</form:label> <br>
    <form:checkboxes path="hobbies" items="${hobbies}" delimiter=""/> <br>
    <form:errors path="hobbies" cssStyle="color: red"/> <br>

    <form:label path="">Faculty</form:label> <br>
    <form:select path="faculty" items="${faculty}" itemValue="id" itemLabel="name"/> <br>
    <form:errors path="faculty" cssStyle="color: red"/> <br>

    <div style="color: green">${message}</div>
    <form:button type="submit">Submit</form:button>
</form:form>
    <form action="form" method="get">
        <button name="lang" value="en">English</button>
        <button name="lang" value="vi">Vietnamese</button>
    </form>
</body>

</html>
