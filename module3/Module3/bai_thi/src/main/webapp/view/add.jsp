<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/10/2022
  Time: 2:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Thêm sản phẩm</h2>
    <p>${mess}</p>
    <form method="post">
        <table border="1px">
            <td>
                <pre>Tên:</pre>
            </td>
            <td><input type="text" name="ten"></td>
            </tr>
            <tr>
                <td>
                    <pre>Giá:</pre>
                </td>
                <td><input type="text" name="gia"></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Số lượng:  </pre>
                </td>
                <td><input type="text" name="soluong"></td>
            </tr>
            </tr>
            <tr>
                <td>
                    <pre>Màu Sắc:  </pre>
                </td>
                <td><input type="text" name="mausac"></td>
            </tr>
            <tr>
                <td>
                    <pre>Mô tả:  </pre>
                </td>
                <td><input type="text" name="mota"></td>
            </tr>
            <tr>
                <td>
                    <pre>Danh mục:</pre>
                </td>
                <td>
                    <select name="danhmuc">
                        <option value="1">Iphone</option>
                        <option value="2">Máy giặt</option>
                        <option value="3">Tủ Lạnh</option>
                        <option value="4">TV</option>
                        <option value="5">Quạt</option>
                        <option value="6">Loa</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>

    </form>
    <a href="sanpham">
        <button type="button">Quay lại</button>
    </a>
</center>
</body>
</html>
