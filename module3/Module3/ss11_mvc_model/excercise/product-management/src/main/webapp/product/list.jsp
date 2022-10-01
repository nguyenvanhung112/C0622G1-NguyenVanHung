<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2022
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=create">
    <button style="margin-bottom: 10px"> Thêm mới sản phẩm</button>
</a>

<form action="/product?action=find" method="post">
    <input type="text" name="name">
    <input type="submit" value="Search">
</form>
<table style="text-align: center" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Attribute</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Thông tin chi tiết</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getAttribute()}</td>
            <td>${product.getPrice()}</td>
            <td>
                <a href="/product?action=edit&id=${product.getId()}">
                    <button>Edit</button>
                </a>
            </td>
            <td>
                <a href="/product?action=delete&id=${product.getId()}">
                    <button name="delete">Delete</button>
                </a>
            </td>
            <td><a href="/product?action=view&id=${product.getId()}">
                <button>Xem</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
