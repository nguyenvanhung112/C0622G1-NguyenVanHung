<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 06/10/2022
  Time: 9:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Edit Villa</h2>
    <form method="post">
        <table border="1px">
            <td>
                <pre>Name:</pre>
            </td>
            <td><input type="text" name="name" value="${facility.serviceName}"></td>
            </tr>
            <tr>
                <td>
                    <pre>Area:</pre>
                </td>
                <td><input type="text" name="area" value="${facility.usingArea}"></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Price:  </pre>
                </td>
                <td><input type="text" name="price" value="${facility.price}"></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Max people:  </pre>
                </td>
                <td><input type="text" name="max_people" value="${facility.maximumPeople}"></td>
            </tr>
            <tr>
                <td>
                    <pre>Rent Type:</pre>
                </td>
                <td>
                    <select name="rent_type_id">
                        <option value="1">year</option>
                        <option value="2">month</option>
                        <option value="3">day</option>
                        <option value="4">hour</option>
                    </select>
                </td>
            </tr>
            <%--            <tr>--%>
            <%--                <td>--%>
            <%--                    <pre>Facility Type:</pre>--%>
            <%--                </td>--%>
            <%--                <td></td>--%>
            <%--            </tr>--%>
            <tr>
                <td>
                    <pre>Standard Room:</pre>
                </td>
                <td><input type="text" name="standard_room" value="${facility.standardRoom}"></td>
            </tr>
            <tr>
                <td>
                    <pre>Description Other Convenience:</pre>
                </td>
                <td>
                    <input type="text" name="description_other_convenience" value="${facility.descriptionOtherConvenience}">
                </td>
            </tr>
            <tr>
                <td>
                    <pre>Pool Area:</pre>
                </td>
                <td>
                    <input type="text" name="pool_area" value="${facility.poolArea}">
                </td>
            </tr>

            <tr>
                <td>
                    <pre>Floors:</pre>
                </td>
                <td>
                    <input type="text" name="number_of_floors" value="${facility.floor}">
                </td>
            </tr>
            <%--            <tr>--%>
            <%--                <td>--%>
            <%--                    <pre>Facility Free:</pre>--%>
            <%--                </td>--%>
            <%--                <td></td>--%>
            <%--            </tr>--%>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
        <input type="hidden" name="facility_free" value=" ">
        <input type="hidden" name="facility_type_id" value="1">
    </form>
    <a href="facility">
        <button type="button">Back List Facility</button>
    </a>
</center>
</body>
</html>
