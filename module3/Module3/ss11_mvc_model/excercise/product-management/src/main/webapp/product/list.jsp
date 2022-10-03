<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2022
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <link rel="stylesheet" href="../product/style.css">
    <style>
        body {
            margin: 10px;
        }
    </style>
    <script>

    </script>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=create">
    <button type="button" class="btn btn-primary" style="margin-bottom: 10px"> Thêm mới sản phẩm</button>
</a>

<form action="/product?action=find" method="post">
    <input type="text" name="name">
    <input type="submit" value="Search" class="btn btn-primary">
</form>
<table id="tableProduct" class="table table-dark" style="text-align: center" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Attribute</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Thông tin chi tiết</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getAttribute()}</td>
            <td>${product.getPrice()}</td>
            <td>
                <a href="/product?action=edit&id=${product.getId()}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#minhChau${product.id}">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade " id="minhChau${product.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn xóa <strong class="text-danger">${product.name}?</strong>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <a href="product?action=delete&id=${product.id}" class="btn btn-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <a href="/product?action=view&id=${product.getId()}">
                    <button type="button" class="btn btn-primary">Xem</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
        const tableFooter = document.getElementById('tableProduct_wrapper');
        tableFooter.classList.add("format-table");
    });

</script>
</body>
</html>

