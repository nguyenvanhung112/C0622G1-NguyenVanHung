<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/09/2022
  Time: 8:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        img {
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<table style="text-align: center" border="1px" width="100%">
    <h1 style="text-align: center">Danh sách khách hàng</h1>
    <tr>
        <td width="10%"><h2>Mã KH</h2></td>
        <td width="20%"><h2>Tên</h2></td>
        <td width="20%"><h2>Ngày sinh</h2></td>
        <td width="30%"><h2>Địa chỉ</h2></td>
        <td width="20%"><h2>Ảnh</h2></td>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td>
                <img src="${customer.getPicture()}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
