<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/10/2022
  Time: 9:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .text-white pre{
            color: white;
            font-family: Arial;
            margin-bottom: 0px;
        }
        .text-white input{
            width: 100%;
        }
    </style>
</head>
<body>
<header style="text-align: center;margin: 5px">
    <h1>List Customer</h1>
    <div><a href="/home"><button type="button" class="btn btn-info">Home</button></a></div>
    <button style="margin-top: 10px" type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#minhChau2">
        Add
    </button>
    <!-- Modal -->
    <div class="modal fade " id="minhChau2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content bg-dark">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel2" style="color: white">Add</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form method="post" action="/hokhau?action=add">
                        <table  border="1px" class="text-white w-100">
                            <tr>
                                <td>
                                    <pre>Name:</pre>
                                </td>
                                <td><input type="text" name="name" ></td>
                            </tr>
                            </tr>
                            <tr>
                                <td>
                                    <pre>Ngày lập: </pre>
                                </td>
                                <td><input type="date" name="ngaylap"></td>
                            </tr>
                            </tr>
                            <tr>
                                <td>
                                    <pre>Địa chỉ:</pre>
                                </td>
                                <td><input type="text" name="diachi" ></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="Save"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <form action="/customer">
        <input type="hidden" name="action" value="find">
        <input type="text" name="name">
        <input type="submit" value="Search" class="btn btn-info">
    </form>
</header>
<table id="tableCustomer" class="table table-dark" style="text-align: center" border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã Hộ Khẩu</th>
        <th>Tên Chủ Hộ</th>
        <th>Số lượng</th>
        <th>Ngày Lập</th>
        <th>Địa Chỉ</th>
        <th>Edit</th>
        <th>Xem danh sách</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach varStatus="count" var="hokhau" items="${hokhauList}">
        <tr>
            <td>${count.count}</td>
            <td>${hokhau.maHoKhau}</td>
            <td>${hokhau.tenChuHo}</td>
            <td>${hokhau.soLuongThanhVien}</td>
            <td>${hokhau.ngayLap}</td>
            <td>${hokhau.diachi}</td>
            <td>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#minhChau${hokhau.maHoKhau}">
                    Edit
                </button>
                <!-- Modal -->
                <div class="modal fade " id="minhChau${hokhau.maHoKhau}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel1">Edit</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form method="post" action="/hokhau?action=edit">
                                    <table  border="1px" class="text-white w-100">
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
                                            <td colspan="2" align="center">
                                                <input type="submit" value="Save"/></td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#quang${hokhau.maHoKhau}">
                    Xem danh sách
                </button>
                <!-- Modal -->
                <div class="modal fade " id="quang${hokhau.maHoKhau}" tabindex="-1" aria-labelledby="exampleModalLabel11" aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel11">Danh Sách</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <c:forEach items="${map.get(hokhau.maHoKhau)}" var="thanhvien">
                                    <p>${thanhvien.ten}</p>
                                </c:forEach>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
