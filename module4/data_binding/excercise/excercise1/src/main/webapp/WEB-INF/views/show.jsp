<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/10/2022
  Time: 11:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email</h1>
<table border="1">
    <thead>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emailList}" var="email">
        <tr>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td><a href="/email/showForm/${email.id}">
                <button type="button">Edit</button>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
