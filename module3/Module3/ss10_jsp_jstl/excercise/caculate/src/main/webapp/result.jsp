<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/09/2022
  Time: 1:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<h1>Result</h1>
<c:choose>
    <c:when test="${operator eq'+'}">
        <h3>${firstOpera} ${operator} ${secondOpera} = ${secondOpera+firstOpera}  </h3>
    </c:when>
    <c:when test="${operator eq'-'}">
        <h3>${firstOpera} ${operator} ${secondOpera} = ${secondOpera-firstOpera}  </h3>
    </c:when>
    <c:when test="${operator eq'*'}">
        <h3>${firstOpera} ${operator} ${secondOpera} = ${secondOpera*firstOpera}  </h3>
    </c:when>
    <c:when test="${operator eq'/'}">
        <c:if test="${secondOpera==0}">
            <h3>Phép chia không hợp lệ</h3>
        </c:if>
        <c:if test="${secondOpera!=0}">
            <h3>${firstOpera} ${operator} ${secondOpera} = ${secondOpera/firstOpera}  </h3>
        </c:if>
    </c:when>
</c:choose>
</body>
</html>
