<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/user?action=create">Add New User</a>
    </h2>
    <form action="/user">
        <input type="hidden" name="action" value="find">
        <input type="text" name="country">
        <input type="submit" value="Search">
    </form>
    <c:if test="${message != null}">
        <p>${message}</p>
    </c:if>
    <caption><h2>List of Users</h2></caption>
</center>
<div align="center">
    <table id="tableUser" border="1px">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
    </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/user?action=edit&id=${user.id}">Edit</a>
                    <a href="/user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div align="center" style="margin-top: 10px">
    <form action="/user">
        <button type="submit" name="action" value="sort">Sắp xếp theo tên</button>
    </form>
</div>
</body>
</html>
