<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2022
  Time: 10:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết</title>
</head>
<body>
<a href="/product">
    <button style="margin-bottom: 10px"> Quay lại</button>
</a>
<form>
    <fieldset>
        <legend>Thông tin chi tiết</legend>
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
    </fieldset>
</form>
</body>
</html>
