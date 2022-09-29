<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/09/2022
  Time: 1:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculate</h1>
<form action="/result" method="get">
    <h3>First Opera <input type="text" name="first-opera"></h3>
    <h3>Operator
        <select name="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select>
    </h3>
    <h3>Second Opera <input type="text" name="second-opera"></h3>
    <button type="submit">Submit</button>
</form>
</body>
</html>
