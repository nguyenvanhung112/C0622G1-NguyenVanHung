
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2022
  Time: 3:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sửa sản phẩm</h1>
<a href="/product">
    <button style="margin-bottom: 10px"> Quay lại</button>
</a>
<p>${message}</p>
<form method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>ID</td>
                <td>${product.getId()}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>Attribute</td>
                <td><input type="text" name="attribute" id="attribute" value="${product.getAttribute()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
