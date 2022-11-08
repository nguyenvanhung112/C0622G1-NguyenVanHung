<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/10/2022
  Time: 1:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" >
    <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
    <input type="checkbox" value="Tomato" name="condiment"> Tomato
    <input type="checkbox" value="Mustard" name="condiment"> Mustard
    <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
    <input type="submit" value="Save">
</form>
<c:forEach items="${condiment}" var="c">
    <p>
        ${c}
    </p>
</c:forEach>

</body>
</html>
