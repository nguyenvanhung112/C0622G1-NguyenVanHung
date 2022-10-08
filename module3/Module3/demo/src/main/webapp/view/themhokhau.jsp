<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08/10/2022
  Time: 9:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Edit Customer</h2>
    <form method="post">
        <table border="1px">
            <tr>
                <td>
                    <pre>Mã hộ khẩu:</pre>
                </td>
                <input type="hidden" name="id" value="${hokhau.maHoKhau}" >
                <td><input type="text" name="id" value="${hokhau.maHoKhau}" disabled></td>
            </tr>
            <tr>
                <td>
                    <pre>Name:</pre>
                </td>
                <td><input type="text" name="name" value="${hokhau.tenChuHo}"></td>
            </tr>
            <tr>
                <td>
                    <pre>Số lượng:</pre>
                </td>
                <input type="hidden" name="soluong" value="${hokhau.soLuongThanhVien}">
                <td><input type="text" name="soluong" value="${hokhau.soLuongThanhVien}" disabled></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Ngày lập: </pre>
                </td>
                <td><input type="date" name="ngaylap" value="${hokhau.ngayLap}"></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Địa chỉ:</pre>
                </td>
                <td><input type="text" name="diachi" value="${hokhau.diachi}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form>
    <a href="hokhau">
        <button type="button">Back List Hộ Khẩu</button>
    </a>
</center>
</body>
</html>
