<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/09/2022
  Time: 1:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Product</h2>
<form action="/display-discount" method="post">
    <input type="text" name="ProductDescription" placeholder="Enter Product Description: ">
    <input type="text" name="ListPrice" placeholder="Enter List Price: "/>
    <input type="text" name="DiscountPercent" placeholder="Enter Discount Percent: "/>
    <input type="submit" id="submit" value="Result"/>
</form>
</body>
</html>
