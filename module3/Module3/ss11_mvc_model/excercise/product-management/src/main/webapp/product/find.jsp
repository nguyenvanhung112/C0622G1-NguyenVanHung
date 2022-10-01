<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2022
  Time: 10:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">
    <button style="margin-bottom: 10px"> Quay lại</button>
</a>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<c:if test="${message == null}">
    <c:forEach items="${products}" var="product"><fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>ID</td>
                <td>${product.getId()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Attribute</td>
                <td>${product.getAttribute()}</td>
            </tr>
            <tr>
                <td>Price</td>
                <td>${product.getPrice()}</td>
            </tr>
        </table>
    </fieldset></c:forEach>
</c:if>
</body>
</html>
