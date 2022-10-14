<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/10/2022
  Time: 2:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="result">
    <h2>Simple Computer</h2>
    <input type="text" name="a" value="${a}">
    <input type="text" name="b" value="${b}"><br>
    <button type="submit" value="summation" name="submit">Addation(+)</button>
    <button type="submit" value="subtraction" name="submit">Subtraction(-)</button>
    <button type="submit" value="multiplication" name="submit">Multiplication(*)</button>
    <button type="submit" value="division" name="submit">Division(/)</button>
</form>
<p>Result : ${result}</p>
</body>
</html>
