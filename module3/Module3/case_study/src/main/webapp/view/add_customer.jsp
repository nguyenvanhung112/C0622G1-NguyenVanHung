<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/10/2022
  Time: 11:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Add New Customer</h2>
    <p>${mess}</p>

    <form method="post">
        <table border="1px">

            <c:if test="${map.get('check')!=null}">
                <p>${map.get('check')}</p>
            </c:if>

            <tr>
                <td>
                    <pre>Customer Type:</pre>
                </td>
                <td>
                    <select name="customer-type">
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <pre>Name:</pre>

                </td>
                <td><input type="text" name="name" size="45"
                           value="${customer.name}">
                    <c:if test="${map.get('name')!=null}">
                        <pre><span style="color:red;">${map.get('name')}</span></pre>
                    </c:if>
                </td>
            </tr>

            <tr>
                <td>
                    <pre>Birthday:</pre>
                </td>
                <td><input type="date" name="birthday" value="${customer.dateOfBirth}"></td>
            </tr>
            <%--            <tr>--%>
            <%--                <td>--%>
            <%--                    <c:if test="${map.get('dateOfBirth')!=null}">--%>
            <%--                        <pre>               <span style="color:red;">${map.get('dateOfBirth')}</span></pre>--%>
            <%--                    </c:if>--%>
            <%--                </td>--%>
            <%--            </tr>--%>
            <tr>
                <td>
                    <pre>ID Card:  </pre>
                </td>
                <td>
                    <input type="text" name="id-card" value="${customer.idCard}">
                    <c:if test="${map.get('idCard')!=null}">
                        <pre><span style="color:red;">${map.get('idCard')}</span></pre>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    <pre>Gender:</pre>
                </td>
                <td><input type="radio" name="gender" value="true" ${customer.gender==true?"checked":""}>Nam
                    <input type="radio" value="false" name="gender" ${customer.gender==false?"checked":""}>Nữ
                </td>
            </tr>
            <tr>
                <td>
                    <pre>Phone Number:</pre>

                </td>
                <td><input type="text" name="phonenumber" size="30" value="${customer.phone}">
                    <c:if test="${map.get('phoneNumber')!=null}">
                        <pre><span style="color:red;">${map.get('phoneNumber')}</span></pre>
                    </c:if>
                </td>
            </tr>

            <tr>
                <td>
                    <pre>Email:</pre>
                </td>
                <td><input type="text" name="email" size="45"
                           value="${customer.email}">
                    <c:if test="${map.get('email')!=null}">
                        <pre><span style="color:red;">${map.get('email')}</span></pre>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    <pre>Address: </pre>

                </td>
                <td><input type="text" name="address" value="${customer.address}">
                    <c:if test="${map.get('address')!=null}">
                        <pre><span style="color:red;">${map.get('address')}</span></pre>
                    </c:if>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form>
    <a href="customer">
        <button type="button">Back List Customer</button>
    </a>
</center>
</body>
</html>
